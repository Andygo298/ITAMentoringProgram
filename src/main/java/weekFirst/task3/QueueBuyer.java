package weekFirst.task3;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueBuyer {
    private static BlockingDeque<Buyer> queue = new LinkedBlockingDeque<>(5);//очередь из 5 покупателей

    static void add(Buyer buyer){
         queue.addLast(buyer);
    }

    static Buyer extract(){
        return queue.pollFirst();
    }

}
