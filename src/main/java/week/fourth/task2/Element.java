package week.fourth.task2;

public interface Element<V> {

    void accept(Visitor<V> visitor);

}
