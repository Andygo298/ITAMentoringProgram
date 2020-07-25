package weekFirst.task3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Market {

    public static void go() {
        new Good(); //создались товары в магазине
        System.err.println("-----------Магазин открылся-----------");
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= Dispetcher.getCountCashier(); i++) {
         executor.execute(new Cashier(i));
        }
        executor.shutdown();

        int number = 0;
        while (Dispetcher.marketOpened()){ //пока магазин открыт..
                if (Dispetcher.marketOpened()){
                    Buyer buyer = new Buyer(++number); // стартуем покупателя
                    buyer.start();
                }
            Helper.sleep(1000);
        }

        try {
            while (!executor.awaitTermination(1000, TimeUnit.MILLISECONDS));{
                System.err.println("-----------Магазин закрылся!-----------");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Кассиры затратили на обслуживание покупателей: " + Dispetcher.getServiceSec() + " секунд(ы).");
    }
}
