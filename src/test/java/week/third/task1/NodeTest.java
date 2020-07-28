package week.third.task1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import week.third.task1.impl.BinaryTree;
import week.third.task1.impl.MyBinaryService;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class NodeTest {
    private BinaryTree<Integer> binaryTree = new BinaryTree<>();
    private TreeService<Integer> treeService = new MyBinaryService<>();

    @BeforeEach
    public void init() {
        binaryTree.add(8);
        binaryTree.add(3);
        binaryTree.add(1);
        binaryTree.add(6);
        binaryTree.add(4);
        binaryTree.add(7);
        binaryTree.add(10);
        binaryTree.add(14);
        binaryTree.add(13);
    }

    @Test
    public void getCountNodesOfTreeRecursiveGoodTest() {
        final int expectedCount = 9;
        int actualCount = treeService.getCountNodesOfTreeRecursive(binaryTree);
        assertNotNull(binaryTree);
        assertEquals(expectedCount, actualCount);
    }

    @Test
    public void getCountNodesOfTreeRecursiveBadTest() {
        final int expectedBadCount = 6;
        int actualCount = treeService.getCountNodesOfTreeRecursive(binaryTree);
        assertNotNull(binaryTree);
        assertNotEquals(expectedBadCount, actualCount);
    }

    @Test
    public void getCountNodesOfTreeCycleGoodTest() {
        final int expectedCount = 9;
        int actualCount = treeService.getCountNodesOfTreeCycle(binaryTree);
        assertNotNull(binaryTree);
        assertEquals(expectedCount, actualCount);
    }

    @Test
    public void getCountNodesOfTreeCycleBadTest() {
        final int expectedBadCount = 6;
        int actualCount = treeService.getCountNodesOfTreeCycle(binaryTree);
        assertNotNull(binaryTree);
        assertNotEquals(expectedBadCount, actualCount);
    }
}