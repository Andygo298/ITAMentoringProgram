package weekSecond.task4;

import java.util.*;
import java.util.stream.Collectors;

public class MySortArrays {

    public List<Integer> sortOnlyOddNumbers(List<Integer> list) {
        List<Integer> out = new ArrayList<>(list);
        Deque<Integer> sortedDequeOddNumbers = list.stream()
                .filter(currNumber -> currNumber % 2 != 0)
                .sorted()
                .collect(Collectors.toCollection(ArrayDeque::new));

        for (int i = 0; i < list.size(); i++) {
            if (out.get(i) % 2 != 0) {
                out.set(i, sortedDequeOddNumbers.pollFirst());
            }
        }
        return out;
    }
}
