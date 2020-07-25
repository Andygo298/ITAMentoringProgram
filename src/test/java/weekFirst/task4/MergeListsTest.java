package weekFirst.task4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MergeListsTest {

    @Test
    void mergeTest() {
        List<Integer> first = new ArrayList<>(Arrays.asList(1,5,10,16,20));
        List<Integer> second = new ArrayList<>(Arrays.asList(2,6,10,19));
        MergeLists mergeLists = new MergeLists();
        mergeLists.merge(first,second);
    }

}