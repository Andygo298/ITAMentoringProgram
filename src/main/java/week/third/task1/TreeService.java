package week.third.task1;

import week.third.task1.impl.BinaryTree;

public interface TreeService<K extends Comparable<K>, V> {
    int getCountNodesOfTreeRecursive(BinaryTree<K, V> binaryTree);

    int getCountNodesOfTreeCycle(BinaryTree<K, V> binaryTree);
}
