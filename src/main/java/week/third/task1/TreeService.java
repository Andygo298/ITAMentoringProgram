package week.third.task1;

import week.third.task1.impl.BinaryTree;

public interface TreeService<V extends Comparable<V>> {
    int getCountNodesOfTreeRecursive(BinaryTree<V> binaryTree);

    int getCountNodesOfTreeCycle(BinaryTree<V> binaryTree);

    int maxDepth(Node<V> nodeRoot);

    String sumStringBfs(BinaryTree<V> binaryTree);
}
