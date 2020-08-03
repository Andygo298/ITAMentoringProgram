package week.fourth.task1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import week.fourth.task1.impl.BinaryTree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class TreeIteratorServiceTest {

    private BinaryTree<String> binaryTree = new BinaryTree<>();
    private TreeIteratorService treeIteratorService = new TreeIteratorService();

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
    void bfsStrategyGoodTest() {
        String expected = "FBGADICEH";
        String actual = treeIteratorService.concatBfs(binaryTree);
        assertEquals(expected, actual);
    }

    @Test
    void bfsStrategyBadTest() {
        String expectedBad = "ABCDEFGHI";
        String actual = treeIteratorService.concatBfs(binaryTree);
        assertNotEquals(expectedBad, actual);
    }

    @Test
    public void dfsPreOrderGoodTest(){
        String expected = "FBADCEGIH";
        String actual = treeIteratorService.concatDfsPreOrder(binaryTree);
        assertEquals(expected, actual);
    }
    @Test
    void dfsPreOrderBadTest() {
        String expectedBad = "ABCDEFGHI";
        String actual = treeIteratorService.concatDfsPreOrder(binaryTree);
        assertNotEquals(expectedBad, actual);
    }

}