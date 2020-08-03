package week.fourth.task2.impl;

import lombok.Getter;
import lombok.Setter;
import week.fourth.task2.SearchStrategy;
import week.fourth.task2.Node;
import week.fourth.task2.Tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

import static java.util.Objects.nonNull;

public class BinaryTree<V extends Comparable<V>> implements Tree<V>, Iterable<V> {

    @Getter
    private Node<V> rootNode;
    @Setter
    private SearchStrategy searchStrategy;

    @Override
    public void add(V value) {
        Node<V> newNode = new Node<>(value);

        if (rootNode == null) {
            rootNode = newNode;
        } else {
            Node<V> focusNode = rootNode;
            Node<V> parent;
            while (true) {
                parent = focusNode;
                if (value.compareTo(focusNode.getValue()) < 0) {
                    focusNode = focusNode.getLeftChild();
                    if (focusNode == null) {
                        parent.setLeftChild(newNode);
                        break;
                    }
                } else {
                    focusNode = focusNode.getRightChild();
                    if (focusNode == null) {
                        parent.setRightChild(newNode);
                        break;
                    }
                }
            }
        }
    }

    @Override
    public Iterator<V> iterator() {
        return new BinaryTreeIterator(rootNode);
    }

    private class BinaryTreeIterator implements Iterator<V> {

        private Deque<Node<V>> nodes;

        public BinaryTreeIterator(Node<V> rootNode) {

            nodes = new ArrayDeque<>();
            if (nonNull(rootNode)) {
                nodes.addFirst(rootNode);
            }
        }

        @Override
        public boolean hasNext() {
            return !nodes.isEmpty();
        }

        @Override
        public V next() {
            return searchStrategy.next(nodes);
        }
    }
}
