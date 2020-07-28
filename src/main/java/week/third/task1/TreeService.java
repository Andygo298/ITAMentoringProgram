package week.third.task1;

import week.third.task1.impl.BinaryTree;

public interface TreeService<T> {
    int getCountNodesOfTreeRecursive(BinaryTree<T> binaryTree);
    int getCountNodesOfTreeCycle(BinaryTree<T> binaryTree);
}
