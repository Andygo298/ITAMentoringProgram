package weekFirst.task2;

import java.util.*;

public class MovieHouse {
    private static final int LENGTH_BUYERS_DEQUE = 3;
    private static final int PRICE_TICKET = 25;
    private List<Buyer> randomBuyers = createBuyers();
    private Clerk clerk = new Clerk("ClerkVasili");

    public List<Buyer> getRandomBuyers() {
        return randomBuyers;
    }

    public void setRandomBuyers(List<Buyer> randomBuyers) {
        this.randomBuyers = randomBuyers;
    }

    public Clerk getClerk() {
        return clerk;
    }

    public void setClerk(Clerk clerk) {
        this.clerk = clerk;
    }

    List<Buyer> createBuyers() {
        List<Buyer> buyers = new ArrayList<>();
        for (int i = 0; i < LENGTH_BUYERS_DEQUE; i++) {
            Buyer buyer = new Buyer("Buyer №" + i);
            buyers.add(buyer);
        }
        return buyers;
    }

    boolean payments(List<Buyer> randomBuyers) {
        for (Buyer buyer : randomBuyers) {
            int buyerMoneyDiff = buyer.getMoney() - PRICE_TICKET;
            if (buyerMoneyDiff >= 0 && buyerMoneyDiff <= clerk.getCashBox()) {
                clerk.setCashBox(clerk.getCashBox() - buyerMoneyDiff + PRICE_TICKET);
            } else {
                return false;
            }
        }
        return true;
    }

}
