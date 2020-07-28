package week.third.task1.impl;

import week.third.task1.Node;
import week.third.task1.TreeService;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicInteger;

public class MyBinaryService<V extends Comparable<V>> implements TreeService<V> {

    private static AtomicInteger count;
    private Node<V> newRootNode;

    @Override
    public int getCountNodesOfTreeRecursive(BinaryTree<V> binaryTree) {
        Node<V> tempNode;

        if (binaryTree == null) {
            return 0;
        }

        if (newRootNode == null) {
            tempNode = binaryTree.getRoot();
            System.out.println(binaryTree.getRoot().getValue());
            count = new AtomicInteger(1);
        } else {
            tempNode = newRootNode;
        }

        if (tempNode.getLeftChild() != null) {
            count.getAndIncrement();
            newRootNode = tempNode.getLeftChild();
            System.out.println(tempNode.getLeftChild().getValue());
            getCountNodesOfTreeRecursive(binaryTree);
        }

        if (tempNode.getRightChild() != null) {
            count.getAndIncrement();
            newRootNode = tempNode.getRightChild();
            System.out.println(tempNode.getRightChild().getValue());
            getCountNodesOfTreeRecursive(binaryTree);
        }
        return count.intValue();
    }

    @Override
    public int getCountNodesOfTreeCycle(BinaryTree<V> binaryTree) {
        Deque<Node<V>> stackNodes = new ArrayDeque<>();

        if (binaryTree == null) {
            return 0;
        } else {
            count = new AtomicInteger(0);
            stackNodes.add(binaryTree.getRoot());
        }

        while (!stackNodes.isEmpty()) {
            Node<V> currentNode = stackNodes.pollFirst();
//            System.out.println(currentNode.getValue());
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
    public int maxDepth(Node<V> nodeRoot) {
        if (nodeRoot == null) {
            return 0;
        }
        int left = maxDepth(nodeRoot.getLeftChild());
        int right = maxDepth(nodeRoot.getRightChild());
        return Math.max(left, right) + 1;
    }

    @Override
    public String sumStringBfs(BinaryTree<V> binaryTree) {
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
}
