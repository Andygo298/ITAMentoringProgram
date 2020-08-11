package week.fourth.task1;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Node<V> {

    @NonNull
    private V value;

    private Node<V> leftChild;
    private Node<V> rightChild;

}
