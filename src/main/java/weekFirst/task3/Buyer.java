package weekFirst.task3;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

class Buyer extends Thread implements IBuyer, IUseBacket {

    private static Semaphore semaphore = new Semaphore(5);//одновременно в магазине могут находиться только 5 покупателей
    private Map<String, Integer> goodBacket = new HashMap<>();
    private boolean flagQueue = false;

    public Map<String, Integer> getGoodBacket() {
        return goodBacket;
    }

    void setFlagQueue(boolean flagQueue) {
        this.flagQueue = flagQueue;
    }

    Buyer(int number) {
        super("Покупатель №" + " " + number);
        Dispetcher.enterBayer(); //++ к счетчику вошедших в магазин
    }

    @Override
    public void run() {
        enterToMarket();
        try {
            semaphore.acquire();// взял разрешение у семафора
            chooseGoods();//выбрал товары
            goToQueue();//стал в очередь
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            semaphore.release(); //освободил
        }
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " " + "вошел в магазин.");

    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " " + "начал выбирать товары.");
        takeBacket();
        System.out.println(this + " " + "закончил выбирать товары.");

    }

    @Override
    public void goToQueue() {
        System.out.println(this + " " + "пошел в очередь.");
        QueueBuyer.add(this);
        synchronized (this) {
            try {
                this.wait();//покупатель стал в очередь и "заснул"
                flagQueue = true; // флаг на то что покупатель стал в очередь
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void goOut() {
        System.out.println(this + " " + "покинул магазин.");
        Dispetcher.leftBayer();

    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void takeBacket() {
        System.out.println(this + " " + "взял корзинку.");
        int countGoods = Helper.random(1, 4); // покупатель берет рандомно от 1 до 4 товаров
        for (int i = 1; i <= countGoods; i++) {
            putGoodsToBacket();
        }

    }

    @Override
    public void putGoodsToBacket() {
        // выбирает рандомный товар из имеющихся в магазине и ложит в корзину
        int goodNumber = Helper.random(0, Good.goodsLength() - 1);
        String good = Good.getGoods(goodNumber);

        String[] array = good.split(" ");
        this.goodBacket.put(array[0], Integer.parseInt(array[1]));

        System.out.println(this + " " + "выбрал" + " " + good + " " + "взял и положил в корзинку.");

    }
}
