package week.fourth.task1;

import java.util.Deque;

public interface DetourStrategy<V> {

    V next(Deque<Node<V>> nodes);

}
