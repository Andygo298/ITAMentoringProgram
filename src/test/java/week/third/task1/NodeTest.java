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
        binaryTree.add("F");
        binaryTree.add("B");
        binaryTree.add("A");
        binaryTree.add("G");
        binaryTree.add("I");
        binaryTree.add("D");
        binaryTree.add("E");
        binaryTree.add("C");
        binaryTree.add("H");
    }

    @Test
    public void getCountNodesOfTreeRecursiveGoodTest() {
        final int expectedCount = 9;
        int actualCount = treeService.getCountNodesRecursive(binaryTree);
        assertEquals(expectedCount, actualCount);
    }

    @Test
    public void getCountNodesOfTreeRecursiveBadTest() {
        final int expectedBadCount = 6;
        int actualCount = treeService.getCountNodesRecursive(binaryTree);
        assertNotEquals(expectedBadCount, actualCount);
    }

    @Test
    public void getCountNodesOfTreeCycleGoodTest() {
        final int expectedCount = 9;
        int actualCount = treeService.getCountNodesCycle(binaryTree);
        assertEquals(expectedCount, actualCount);
    }

    @Test
    public void getCountNodesOfTreeCycleBadTest() {
        final int expectedBadCount = 6;
        int actualCount = treeService.getCountNodesCycle(binaryTree);
        assertNotEquals(expectedBadCount, actualCount);
    }

    @Test
    public void maxDepthGoodTest() {
        final int expected = 4;
        int actualDepth = treeService.maxDepth(binaryTree);
        assertEquals(expected, actualDepth);
    }

    @Test
    public void maxDepthBadTest() {
        final int expectedBad = 5;
        int actualDepth = treeService.maxDepth(binaryTree);
        assertNotEquals(expectedBad, actualDepth);
    }

    @Test
    public void concatBfsGoodTest() {
        String expectedBfs = "FBGADICEH";
        String actualBfs = treeService.concatBfs(binaryTree);
        assertEquals(expectedBfs, actualBfs);
    }

    @Test
    public void concatBfsBadTest() {
        String expectedBfs = "ABCDEFGHI";
        String actualBfs = treeService.concatBfs(binaryTree);
        assertNotEquals(expectedBfs, actualBfs);
    }

    @Test
    public void concatDfsPreOrderGoodTest() {
        String expected = "FBADCEGIH";
        String actual = treeService.concatDfsPreOrder(binaryTree);
        assertEquals(expected, actual);
    }
    @Test
    public void concatDfsPreOrderBadTest() {
        String expected = "ABCDEFGHI";
        String actual = treeService.concatDfsPreOrder(binaryTree);
        assertNotEquals(expected, actual);
    }

    @Test
    public void concatDfsInOrderGoodTest() {
        String expected = "ABCDEFGHI";
        String actual = treeService.concatDfsInOrder(binaryTree);
        assertEquals(expected, actual);
    }
    @Test
    public void concatDfsInOrderBadTest() {
        String expected = "IHGACDBFE";
        String actual = treeService.concatDfsInOrder(binaryTree);
        assertNotEquals(expected, actual);
    }

    @Test
    public void concatDfsPostOrderGoodTest() {
        String expected = "ACEDBHIGF";
        String actual = treeService.concatDfsPostOrder(binaryTree);
        assertEquals(expected, actual);
    }

    @Test
    public void concatDfsPostOrderBadTest() {
        String expected = "ACEBGDHIF";
        String actual = treeService.concatDfsPostOrder(binaryTree);
        assertNotNull(actual);
        assertNotEquals(expected, actual);
    }
}