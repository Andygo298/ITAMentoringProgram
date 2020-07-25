package weekFirst.task3;

import java.util.concurrent.atomic.AtomicInteger;

class Dispetcher {
    static final int K_SPEED = 1;//скорость

    private static final int PLAN = 12; //план по обслуживанию покупателей
    private static final int countCashier = 3; // количество кассиров

    private static AtomicInteger countBuyer = new AtomicInteger(0);
    private static AtomicInteger enterBuyer = new AtomicInteger(0);
    private static AtomicInteger serviceSec = new AtomicInteger(0);

    public static int getServiceSec() {
        return serviceSec.intValue();
    }
    public static int getCountCashier() {
        return countCashier;
    }

    static void enterBayer() {
        enterBuyer.getAndIncrement();
        countBuyer.getAndIncrement();
        //плюс к вошедшим и плюс к общим покупателям
    }

    static void incSecService(int sec) {
        serviceSec.set(serviceSec.get() + sec);
    }

    static void leftBayer() {
        countBuyer.getAndDecrement();
    } //минус покупатель

    static boolean marketOpened() {
        return enterBuyer.get() < PLAN;
    }// магаз открыт пока есть покупатели

    static boolean marketClosed() {
        return PLAN == enterBuyer.get() && countBuyer.get() == 0;
    } //магазин закроется после достижения плана
}
