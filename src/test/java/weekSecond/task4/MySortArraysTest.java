package weekSecond.task4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MySortArraysTest {

    private MySortArrays mySortArrays = new MySortArrays();
    private List<Integer> testList1 = new ArrayList<>(Arrays.asList(5, 3, 2, 8, 1, 4));
    private List<Integer> testList2 = new ArrayList<>(Arrays.asList(19, 6, 4, 1, 3, 10, 8, 6, 2, 14, 5, 11, 19, 18));

    @Test
    void sortOnlyOddNumbers() {
        final List<Integer> expList1 = new ArrayList<>(Arrays.asList(1, 3, 2, 8, 5, 4));
        final List<Integer> expList2 = new ArrayList<>(Arrays.asList(1, 6, 4, 3, 5, 10, 8, 6, 2, 14, 11, 19, 19, 18));

        List<Integer> actual1 = mySortArrays.sortOnlyOddNumbers(testList1);
        List<Integer> actual2 = mySortArrays.sortOnlyOddNumbers(testList2);

        assertNotNull(testList1);
        assertNotNull(testList2);

        assertEquals(expList1, actual1);
        assertEquals(expList2, actual2);
    }
}