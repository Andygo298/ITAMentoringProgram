package week.fourth.task2;

import week.fourth.task2.enums.Strategy;
import week.fourth.task2.impl.BinaryTree;

import java.util.Iterator;

public class TreeIteratorService {

    public <V extends Comparable<V>> String concatDfsPreOrder(BinaryTree<V> binaryTree) {
        StringBuilder result = new StringBuilder();
        binaryTree.setSearchStrategy(Strategy.DEPTH_FIRST_SEARCH_PRE_ORDER);
        Iterator<V> iterator = binaryTree.iterator();

        while (iterator.hasNext()) {
            result.append(iterator.next());
        }
        return result.toString();
    }

    public <V extends Comparable<V>> String concatBfs(BinaryTree<V> binaryTree) {
        StringBuilder result = new StringBuilder();
        binaryTree.setSearchStrategy(Strategy.BREADTH_FIRST_SEARCH);
        Iterator<V> iterator = binaryTree.iterator();

        while (iterator.hasNext()) {
            result.append(iterator.next());
        }
        return result.toString();
    }
}
