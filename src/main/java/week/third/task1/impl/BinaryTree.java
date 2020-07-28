package week.third.task1.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import week.third.task1.Node;
import week.third.task1.Tree;

@NoArgsConstructor
public class BinaryTree<T> implements Tree<T> {

    @Getter
    private Node<T> root;

    @Override
    public void add(int key, T data) {
        Node<T> newNode = new Node<>(key, data);

        if (root == null) {
            root = newNode;
        } else {
            Node<T> focusNode = root;
            Node<T> parent;
            while (true) {
                parent = focusNode;
                if (key < focusNode.getKey()) {
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
