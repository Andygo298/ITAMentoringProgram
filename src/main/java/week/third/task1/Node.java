package week.third.task1;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Node<T> {

    @NonNull
    private int key;
    @NonNull
    private T data;

    private Node<T> leftChild;
    private Node<T> rightChild;

}
