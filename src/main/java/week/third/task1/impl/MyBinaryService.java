package week.third.task1.impl;

import week.third.task1.Node;
import week.third.task1.TreeService;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.Objects.nonNull;

public class MyBinaryService<V extends Comparable<V>> implements TreeService<V> {

    private AtomicInteger count;
    private Node<V> newRootNode;

    @Override
    public int getCountNodesRecursive(BinaryTree<V> binaryTree) {
        Node<V> tempNode;

        if (binaryTree == null) {
            return 0;
        }

        if (newRootNode == null) {
            tempNode = binaryTree.getRoot();
            count = new AtomicInteger(1);
        } else {
            tempNode = newRootNode;
        }

        if (tempNode.getLeftChild() != null) {
            count.getAndIncrement();
            newRootNode = tempNode.getLeftChild();
            getCountNodesRecursive(binaryTree);
        }

        if (tempNode.getRightChild() != null) {
            count.getAndIncrement();
            newRootNode = tempNode.getRightChild();
            getCountNodesRecursive(binaryTree);
        }
        return count.intValue();
    }

    @Override
    public int getCountNodesCycle(BinaryTree<V> binaryTree) {
        Deque<Node<V>> dequeNodes = new ArrayDeque<>();

        if (binaryTree == null) {
            return 0;
        } else {
            dequeNodes.add(binaryTree.getRoot());
            count = new AtomicInteger(0);
        }

        while (!dequeNodes.isEmpty()) {
            Node<V> currentNode = dequeNodes.pollFirst();
            count.getAndIncrement();

            if (currentNode.getRightChild() != null) {
                dequeNodes.addFirst(currentNode.getRightChild());
            }
            if (currentNode.getLeftChild() != null) {
                dequeNodes.addFirst(currentNode.getLeftChild());
            }
        }
        return count.intValue();
    }

    @Override
    public int maxDepth(BinaryTree<V> binaryTree) {
        Node<V> node = binaryTree.getRoot();
        return getDepth(node);
    }

    @Override
    public String concatBfs(BinaryTree<V> binaryTree) {
        Deque<Node<V>> dequeNodes = new ArrayDeque<>();
        StringBuilder stringBuilder = new StringBuilder();

        if (binaryTree == null) {
            return "";
        } else {
            dequeNodes.add(binaryTree.getRoot());
        }

        while (!dequeNodes.isEmpty()) {
            Node<V> currentNode = dequeNodes.pollFirst();
            stringBuilder.append(currentNode.getValue());

            if (currentNode.getLeftChild() != null) {
                dequeNodes.add(currentNode.getLeftChild());
            }
            if (currentNode.getRightChild() != null) {
                dequeNodes.add(currentNode.getRightChild());
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public String concatDfsInOrder(BinaryTree<V> binaryTree) {
        if (binaryTree == null) {
            return "";
        }
        return dfsInOrder(binaryTree.getRoot());
    }

    @Override
    public String concatDfsPreOrder(BinaryTree<V> binaryTree) {
        if (binaryTree == null) {
            return "";
        }
        return dfsPreOrder(binaryTree.getRoot());
    }

    @Override
    public String concatDfsPostOrder(BinaryTree<V> binaryTree) {
        if (binaryTree == null) {
            return "";
        }
        return dfsPostOrder(binaryTree.getRoot());
    }

    private int getDepth(Node<V> node) {
        if (node == null) {
            return 0;
        }
        int left = getDepth(node.getLeftChild());
        int right = getDepth(node.getRightChild());
        return Math.max(left, right) + 1;
    }

    private String dfsInOrder(Node<V> node) {
        StringBuilder stringBuilder = new StringBuilder();
        if (nonNull(node)) {
        stringBuilder.append(dfsInOrder(node.getLeftChild()));
        stringBuilder.append(node.getValue());
        stringBuilder.append(dfsInOrder(node.getRightChild()));
    }
        return stringBuilder.toString();
    }

    private String dfsPreOrder(Node<V> node) {
        StringBuilder stringBuilder = new StringBuilder();
        if (nonNull(node)) {
            stringBuilder.append(node.getValue());
            stringBuilder.append(dfsInOrder(node.getLeftChild()));
            stringBuilder.append(dfsInOrder(node.getRightChild()));
        }
        return stringBuilder.toString();
    }

    private String dfsPostOrder(Node<V> node) {
        StringBuilder stringBuilder = new StringBuilder();
        if (nonNull(node)) {
            stringBuilder.append(dfsInOrder(node.getLeftChild()));
            stringBuilder.append(dfsInOrder(node.getRightChild()));
            stringBuilder.append(node.getValue());
        }
        return stringBuilder.toString();
    }

}
