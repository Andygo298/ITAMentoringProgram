package week.third.task1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import week.third.task1.impl.BinaryTree;
import week.third.task1.impl.MyBinaryService;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class NodeTest {
    private BinaryTree<Integer, String> binaryTree = new BinaryTree<>();
    private TreeService<Integer, String> treeService = new MyBinaryService<>();

    @BeforeEach
    public void init() {
        binaryTree.add(8, "eight");
        binaryTree.add(3, "three");
        binaryTree.add(1, "one");
        binaryTree.add(6, "six");
        binaryTree.add(4, "four");
        binaryTree.add(7, "seven");
        binaryTree.add(10, "ten");
        binaryTree.add(14, "fourteen");
        binaryTree.add(13, "thirteen");
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
        int actualCount = treeService.getCountNodesOfTreeRecursive(binaryTree);
        assertNotNull(binaryTree);
        assertNotEquals(expectedBadCount, actualCount);
    }
}