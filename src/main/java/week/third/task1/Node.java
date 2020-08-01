package week.third.task1;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.NonNull;

@Data
@RequiredArgsConstructor
public class Node<V> {

    @NonNull
    private V value;

    private Node<V> leftChild;
    private Node<V> rightChild;

}
