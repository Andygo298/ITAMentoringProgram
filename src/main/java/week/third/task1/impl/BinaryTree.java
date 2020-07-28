package week.third.task1.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import week.third.task1.Node;
import week.third.task1.Tree;

@NoArgsConstructor
public class BinaryTree<K,V> implements Tree<K,V> {

    @Getter
    private Node<K,V> root;

    @Override
    public void add(K key, V data) {
        Node<K,V> newNode = new Node<>(key, data);

        if (root == null) {
            root = newNode;
        } else {
            Node<K,V> focusNode = root;
            Node<K,V> parent;
            while (true) {
                parent = focusNode;
                if (key.equals(focusNode.getKey())) {
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
