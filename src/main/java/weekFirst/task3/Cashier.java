package weekFirst.task3;

import java.util.Map;

class Cashier implements Runnable {

    private String name;

    Cashier(int number) {
        name = "***КАССИР № " + number + " ";
    }

    @Override
    public void run() {
        System.out.println(this + "открылся."); //кассир открылся
        while (!Dispetcher.marketClosed()) {//пока магазин не закрыт
            Buyer buyer = QueueBuyer.extract();//достать покупателя из очереди
            if (buyer != null) {
                System.out.println(this + "начал обслуживание" + " " + buyer + ".");
                serviceBuyer(buyer.getGoodBacket(), buyer);
                System.out.println(this + "закончил обслуживание" + " " + buyer + ".");
                synchronized (buyer) {
                    buyer.notify(); // отпускаем покупателя после обслуживания
                    buyer.setFlagQueue(false); // и ставим флаг очереди в false
                }
            } else {
                Helper.sleep(20);
            }
        }
        System.out.println(this + "закрылся.");
    }

    private void serviceBuyer(Map<String, Integer> goodBacket, Buyer buyer) {
        int sumReceipt = 0;
        long start = System.nanoTime();
        for (Map.Entry<String, Integer> entry : goodBacket.entrySet()) {
            System.out.println(this + "взял товар -> " + entry.getKey() + " стоимостью: " + entry.getValue() + " из корзины " + buyer);
            sumReceipt += entry.getValue();
            Helper.sleep(1001);
            Dispetcher.incSecService(1); //добавил +1сек к счетчику секунд обслуживания
        }
        long finish = System.nanoTime();
        long res = (finish - start) / 1_000_000_000;
        System.out.println(this + buyer.toString() + " сумма чека = " + sumReceipt + "."+
                '\n'+ this +" затратил на обслуживание "+ buyer.toString() +" :" + res + " сек.");
    }

    @Override
    public String toString() {
        return name;
    }
}
