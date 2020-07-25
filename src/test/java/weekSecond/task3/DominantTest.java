package weekSecond.task3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DominantTest {

    private Dominant dominant = new Dominant();
    private List<Integer> arr1 = new ArrayList<>(Arrays.asList(10, 9, 9, 9, 10));
    private List<Integer> arr2 = new ArrayList<>(Arrays.asList(3, 2, 3));
    private List<Integer> arr3 = new ArrayList<>(Arrays.asList(2, 2, 1, 1, 1, 2, 2));

    @Test
    void getDominantTest() {
        final Integer expected1 = 9;
        final Integer expected2 = 3;
        final Integer expected3 = 2;

        long start1 = System.nanoTime();
        Integer actualDominant1 = dominant.get(arr1);
        Integer actualDominant2 = dominant.get(arr2);
        Integer actualDominant3 = dominant.get(arr3);
        long finish1 = System.nanoTime();
        long res1 = finish1 - start1;

        long start2 = System.nanoTime();
        Integer actualDominant4 = dominant.getWithMap(arr1);
        Integer actualDominant5 = dominant.getWithMap(arr2);
        Integer actualDominant6 = dominant.getWithMap(arr3);
        long finish2 = System.nanoTime();
        long res2 = finish2 - start2;

        assertEquals(expected1, actualDominant1);
        assertEquals(expected2, actualDominant2);
        assertEquals(expected3, actualDominant3);
        assertEquals(expected1, actualDominant4);
        assertEquals(expected2, actualDominant5);
        assertEquals(expected3, actualDominant6);

        System.out.println("get: " + res1 + " ns." + "     getWithMap: " + res2 + " ns.");
    }
}