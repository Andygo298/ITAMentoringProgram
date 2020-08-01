package week.fourth.task1.impl;

import week.fourth.task1.DetourStrategy;
import week.fourth.task1.Node;

import java.util.Deque;

import static java.util.Objects.nonNull;

public class DfsPreOrderStrategy<V> implements DetourStrategy<V> {

    @Override
    public V next(Deque<Node<V>> nodes) {
        Node<V> currNode = nodes.removeFirst();
        V result = currNode.getValue();
        if (nonNull(currNode.getRightChild())) {
            nodes.addFirst(currNode.getRightChild());
        }
        if (nonNull(currNode.getLeftChild())) {
            nodes.addFirst(currNode.getLeftChild());
        }
        return result;
    }

}
