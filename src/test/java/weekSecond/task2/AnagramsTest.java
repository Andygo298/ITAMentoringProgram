package weekSecond.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnagramsTest {

    private List<String> testStrings = new ArrayList<>(Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat"));
    private Anagrams anagrams = new Anagrams();

    @Test
    void toSortedAnagramsListsTest() {
        final List<String> exp1 = new ArrayList<>(Arrays.asList("ate", "eat", "tea"));
        final List<String> exp2 = new ArrayList<>(Arrays.asList("nat", "tan"));
        final List<String> exp3 = new ArrayList<>(Collections.singletonList("bat"));
        List<List<String>> lists = anagrams.toSortedAnagramsLists(testStrings);
        assertNotNull(lists);
        assertEquals(exp1, lists.get(0));
        assertEquals(exp2, lists.get(1));
        assertEquals(exp3, lists.get(2));
    }
}