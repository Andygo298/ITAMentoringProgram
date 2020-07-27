package week.third.task1;

import week.third.task1.impl.BinaryTree;

public interface TreeService {
    int getCountNodesOfTreeRecursive(BinaryTree binaryTree);
    int getCountNodesOfTreeCycle(BinaryTree binaryTree);
}
