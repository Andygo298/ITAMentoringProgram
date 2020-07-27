package week.third.task1.impl;

import week.third.task1.Node;
import week.third.task1.TreeService;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicInteger;

public class MyBinaryService implements TreeService {

    private static AtomicInteger count;
    private static Node newRootNode;


    @Override
    public int getCountNodesOfTreeRecursive(BinaryTree binaryTree) {
        Node tempNode;

        if (binaryTree == null) {
            return new AtomicInteger(0).intValue();
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
            getCountNodesOfTreeRecursive(binaryTree);
        }

        if (tempNode.getRightChild() != null) {
            count.getAndIncrement();
            newRootNode = tempNode.getRightChild();
            getCountNodesOfTreeRecursive(binaryTree);
        }
        return count.intValue();
    }

    @Override
    public int getCountNodesOfTreeCycle(BinaryTree binaryTree) {
        Deque<Node> stackNodes = new ArrayDeque<>();

        if (binaryTree == null) {
            return new AtomicInteger(0).intValue();
        } else {
            count = new AtomicInteger(0);
            stackNodes.add(binaryTree.getRoot());
        }

        while (!stackNodes.isEmpty()) {
            Node currentNode = stackNodes.pollFirst();
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
}
