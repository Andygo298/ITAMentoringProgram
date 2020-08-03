package week.fourth.task1;

import java.util.Deque;

public interface SearchStrategy {

    <V> V next(Deque<Node<V>> deque);

}
