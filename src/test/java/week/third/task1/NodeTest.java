package week.third.task1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import week.third.task1.impl.BinaryTree;
import week.third.task1.impl.MyBinaryService;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class NodeTest {
    private BinaryTree<String> binaryTree = new BinaryTree<>();
    private TreeService<String> treeService = new MyBinaryService<>();

    @BeforeEach
    public void init() {
        binaryTree.add("f");
        binaryTree.add("a");
        binaryTree.add("c");
        binaryTree.add("g");
        binaryTree.add("h");
        binaryTree.add("b");
        binaryTree.add("d");
        binaryTree.add("i");
        binaryTree.add("e");
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

    @Test
    public void maxDepthGoodTest() {
        final int expected = 5;
        int actualDepth = treeService.maxDepth(binaryTree.getRoot());
        assertEquals(expected, actualDepth);
    }

    @Test
    public void maxDepthBadTest() {
        final int expectedBad = 6;
        int actualDepth = treeService.maxDepth(binaryTree.getRoot());
        assertNotEquals(expectedBad, actualDepth);
    }

    @Test
    public void bfsStringGoodTest() {
        String expectedBfs = "fagchbdie";
        String actualBfs = treeService.sumStringBfs(binaryTree);
        assertNotNull(actualBfs);
        assertEquals(expectedBfs, actualBfs);
    }

    @Test
    public void bfsStringBadTest() {
        String expectedBfs = "abcdefghi";
        String actualBfs = treeService.sumStringBfs(binaryTree);
        assertNotNull(actualBfs);
        assertNotEquals(expectedBfs, actualBfs);
    }
}