package week.fourth.task1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import week.fourth.task1.impl.BinaryTree;

class TreeIteratorServiceTest {

    private BinaryTree<String> binaryTree = new BinaryTree<>();
    private TreeIteratorService treeIteratorService = new TreeIteratorService();

    @BeforeEach
    public void init(){
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
        String actual = treeIteratorService.concatBfs(binaryTree);
    }

}