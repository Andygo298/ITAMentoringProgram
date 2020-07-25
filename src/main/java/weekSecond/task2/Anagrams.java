package weekSecond.task2;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class Anagrams {

    private Map<String, List<String>> stringMap = new LinkedHashMap<>();

    public List<List<String>> toSortedAnagramsLists(List<String> strings) {
        for (String element : strings) {
            List<Character> chars = element.chars()
                    .mapToObj(e -> (char) e)
                    .sorted()
                    .collect(Collectors.toList());

            String sortedString = StringUtils.join(chars, "");

            if (stringMap.containsKey(sortedString)) {
                List<String> getStrings = stringMap.get(sortedString);
                getStrings.add(element);
            } else {
                stringMap.put(sortedString, new ArrayList<>(Collections.singletonList(element)));
            }
        }

        List<List<String>> lists = new ArrayList<>(stringMap.values());
        lists.forEach(Collections::sort);

        return lists;
    }

}
