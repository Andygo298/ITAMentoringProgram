package week.third.task1;

import week.third.task1.impl.BinaryTree;

public interface TreeService<V extends Comparable<V>> {
    int getCountNodesRecursive(BinaryTree<V> binaryTree);

    int getCountNodesCycle(BinaryTree<V> binaryTree);

    int maxDepth(Node<V> nodeRoot);

    String concatBfs(BinaryTree<V> binaryTree);

    String concatDfsPreOrder(BinaryTree<V> binaryTree);

    String concatDfsInOrder(BinaryTree<V> binaryTree);

    String concatDfsPostOrder(BinaryTree<V> binaryTree);
}
