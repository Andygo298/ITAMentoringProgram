package weekSecond.task3;

import java.util.*;

public class Dominant {

    public Integer get(List<Integer> list) {
        int count = 0;
        int candidate = 0;

        for (int i = 0; i < list.size(); i++) {
            if (count == 0) {
                candidate = i;
                count++;
            } else {
                if (list.get(i).equals(list.get(candidate))) {
                    count++;
                } else count--;
            }
        }
        return list.get(candidate);
    }

    public Integer getWithMap(List<Integer> list) {
        Map<Integer, Integer> integerMap = new HashMap<>();

        for (Integer i : list) {
            if (!integerMap.containsKey(i)) {
                integerMap.put(i, 1);
            } else {
                integerMap.put(i, integerMap.get(i) + 1);
            }
        }
        Integer maxValue = Collections.max(integerMap.values());
        return integerMap.entrySet().stream()
                .filter(entry -> maxValue.equals(entry.getValue()))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

    }
}
