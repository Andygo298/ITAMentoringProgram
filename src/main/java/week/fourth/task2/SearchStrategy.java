package week.fourth.task2;

import java.util.Deque;

public interface SearchStrategy {

    <V> V next(Deque<Node<V>> deque);

}
