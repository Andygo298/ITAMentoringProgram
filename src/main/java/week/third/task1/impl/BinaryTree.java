package week.third.task1.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import week.third.task1.Node;
import week.third.task1.Tree;

@NoArgsConstructor
public class BinaryTree implements Tree {

    @Getter
    private Node root;

    @Override
    public void add(int key, String name) {
        Node newNode = new Node(key, name);

        if (root == null) {
            root = newNode;
        } else {
            Node focusNode = root;
            Node parent;
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
