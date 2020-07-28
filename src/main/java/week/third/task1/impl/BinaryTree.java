package week.third.task1.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import week.third.task1.Node;
import week.third.task1.Tree;

@NoArgsConstructor
public class BinaryTree<V extends Comparable<V>> implements Tree<V> {

    @Getter
    private Node<V> root;

    @Override
    public void add(V value) {
        Node<V> newNode = new Node<>(value);

        if (root == null) {
            root = newNode;
        } else {
            Node<V> focusNode = root;
            Node<V> parent;
            while (true) {
                parent = focusNode;
                if (value.compareTo(focusNode.getValue()) < 0) {
                    focusNode = focusNode.getLeftChild();
                    if (focusNode == null) {
                        parent.setLeftChild(newNode);
                        return;
                    }
                } else {
                    focusNode = focusNode.getRightChild();
                    if (focusNode == null) {
                        parent.setRightChild(newNode);
                        return;
                    }
                }
            }
        }
    }
}
