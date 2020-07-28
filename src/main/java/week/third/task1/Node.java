package week.third.task1;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Node<V> {

    @NonNull
    private V value;

    private Node<V> leftChild;
    private Node<V> rightChild;

}
