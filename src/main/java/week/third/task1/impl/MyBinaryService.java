package week.third.task1.impl;

import week.third.task1.Node;
import week.third.task1.TreeService;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicInteger;

public class MyBinaryService<V extends Comparable<V>> implements TreeService<V> {

    private AtomicInteger count = new AtomicInteger(0);
    private Node<V> newRootNode;

    @Override
    public int getCountNodesRecursive(BinaryTree<V> binaryTree) {
        Node<V> tempNode;

        if (binaryTree == null) {
            return 0;
        }

        if (newRootNode == null) {
            tempNode = binaryTree.getRoot();
            count.getAndIncrement();
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
        Deque<Node<V>> stackNodes = new ArrayDeque<>();

        if (binaryTree == null) {
            return 0;
        } else {
            stackNodes.add(binaryTree.getRoot());
        }

        while (!stackNodes.isEmpty()) {
            Node<V> currentNode = stackNodes.pollFirst();
            count.getAndIncrement();

            if (currentNode.getRightChild() != null) {
                stackNodes.addFirst(currentNode.getRightChild());
            }
            if (currentNode.getLeftChild() != null) {
                stackNodes.addFirst(currentNode.getLeftChild());
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
        Deque<Node<V>> stackNodes = new ArrayDeque<>();
        StringBuilder stringBuilder = new StringBuilder();

        if (binaryTree == null) {
            return "";
        } else {
            stackNodes.add(binaryTree.getRoot());
        }

        while (!stackNodes.isEmpty()) {
            Node<V> currentNode = stackNodes.pollFirst();
            stringBuilder.append(currentNode.getValue());

            if (currentNode.getLeftChild() != null) {
                stackNodes.add(currentNode.getLeftChild());
            }
            if (currentNode.getRightChild() != null) {
                stackNodes.add(currentNode.getRightChild());
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public String concatDfsInOrder(BinaryTree<V> binaryTree) {
        StringBuilder stringBuilder = new StringBuilder();
        if (binaryTree == null) {
            return "";
        }
        return dfsInOrder(binaryTree.getRoot(), stringBuilder).toString();
    }

    @Override
    public String concatDfsPreOrder(BinaryTree<V> binaryTree) {
        StringBuilder stringBuilder = new StringBuilder();
        if (binaryTree == null) {
            return "";
        }
        return dfsPreOrder(binaryTree.getRoot(), stringBuilder).toString();
    }

    @Override
    public String concatDfsPostOrder(BinaryTree<V> binaryTree) {
        StringBuilder stringBuilder = new StringBuilder();
        if (binaryTree == null) {
            return "";
        }
        return dfsPostOrder(binaryTree.getRoot(), stringBuilder).toString();
    }

    private int getDepth(Node<V> node) {
        if (node == null) {
            return 0;
        }
        int left = getDepth(node.getLeftChild());
        int right = getDepth(node.getRightChild());
        return Math.max(left, right) + 1;
    }

    private StringBuilder dfsInOrder(Node<V> node, StringBuilder stringBuilder) {
        if (node == null) {
            return null;
        }
        dfsInOrder(node.getLeftChild(), stringBuilder);
        stringBuilder.append(node.getValue());
        dfsInOrder(node.getRightChild(), stringBuilder);
        return stringBuilder;
    }

    private StringBuilder dfsPreOrder(Node<V> node, StringBuilder stringBuilder) {
        if (node == null) {
            return null;
        }
        stringBuilder.append(node.getValue());
        dfsPreOrder(node.getLeftChild(), stringBuilder);
        dfsPreOrder(node.getRightChild(), stringBuilder);
        return stringBuilder;
    }

    private StringBuilder dfsPostOrder(Node<V> node, StringBuilder stringBuilder) {
        if (node == null) {
            return null;
        }
        dfsPostOrder(node.getLeftChild(), stringBuilder);
        dfsPostOrder(node.getRightChild(), stringBuilder);
        stringBuilder.append(node.getValue());
        return stringBuilder;
    }
}
