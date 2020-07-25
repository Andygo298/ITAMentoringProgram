package weekFirst.task2;

public class Buyer extends Person {
    private int money = calcRandomBanknote();

    public Buyer(String name) {
        super(name);
    }

    public int getMoney() {
        return money;
    }

    private int calcRandomBanknote() {
        int[] banknote = new int[]{25, 50, 100};
        return banknote[(int) Math.floor(Math.random() * banknote.length)];
    }

    @Override
    public String toString() {
        return "buyer name: " + super.name + ", money: " + this.money;
    }
}
