package week.third.task1;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Node {

    @NonNull
    private int key;
    @NonNull
    private String name;

    private Node leftChild;
    private Node rightChild;

}
