package weekFirst.task2;

public class Clerk extends Person {
    private int cashBox = 0;

    public Clerk(String name) {
        super(name);
    }

    public int getCashBox() {
        return cashBox;
    }

    public void setCashBox(int cashBox) {
        this.cashBox = cashBox;
    }

    @Override
    public String toString() {
        return "Clerk{" +
                "name='" + super.name + '\'' +
                ", cashBox=" + this.cashBox +
                '}';
    }
}
