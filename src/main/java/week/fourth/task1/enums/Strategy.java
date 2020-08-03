package week.fourth.task1.enums;

import week.fourth.task1.SearchStrategy;
import week.fourth.task1.Node;

import java.util.Deque;

import static java.util.Objects.nonNull;

public enum Strategy implements SearchStrategy {

    BREADTH_FIRST_SEARCH {
        @Override
        public <V> V next(Deque<Node<V>> nodes) {
            Node<V> currNode = nodes.removeLast();
            V result = currNode.getValue();
            if (nonNull(currNode.getLeftChild())) {
                nodes.addFirst(currNode.getLeftChild());
            }
            if (nonNull(currNode.getRightChild())) {
                nodes.addFirst(currNode.getRightChild());
            }
            return result;
        }
    },

    DEPTH_FIRST_SEARCH_PRE_ORDER {
        @Override
        public <V> V next(Deque<Node<V>> nodes) {
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

}
