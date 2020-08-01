package week.fourth.task1;

import week.fourth.task1.impl.BfsStrategy;
import week.fourth.task1.impl.BinaryTree;
import week.fourth.task1.impl.DfsPreOrderStrategy;

import java.util.Iterator;

public class TreeIteratorService{

    public <V extends Comparable<V>> String concatDfsPreOrder(BinaryTree<V> binaryTree){
        StringBuilder result = new StringBuilder();
        binaryTree.setDetourStrategy(new DfsPreOrderStrategy<V>());
        Iterator<V> iterator = binaryTree.iterator();

        while (iterator.hasNext()){
            result.append(iterator.next());
        }
        return result.toString();
    }

    public <V extends Comparable<V>> String concatBfs(BinaryTree<V> binaryTree){
        StringBuilder result = new StringBuilder();
        binaryTree.setDetourStrategy(new BfsStrategy<V>());
        Iterator<V> iterator = binaryTree.iterator();

        while (iterator.hasNext()){
            result.append(iterator.next());
        }
        return  result.toString();
    }
}
