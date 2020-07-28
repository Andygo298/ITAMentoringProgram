package week.third.task1;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Node<K, V> {

    @NonNull
    private K key;
    @NonNull
    private V value;

    private Node<K, V> leftChild;
    private Node<K, V> rightChild;

}
