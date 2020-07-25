package weekFirst.task1;

import org.junit.jupiter.api.Test;
import weekFirst.task1.impl.RegExpNumberTransformer;
import weekFirst.task1.impl.SimpleNumberTransformer;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberTransformerTest {

    private List<Integer> testList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);

    @Test
    public void RegExpNumberFormatTest() {
        NumberTransformer numberTransformer = new RegExpNumberTransformer();
        String afterFormat = numberTransformer.toFormat(testList);
        System.out.println(afterFormat + " -- by RegExp");
    }

    @Test
    public void SimpleNumberFormatTest() {
        NumberTransformer numberTransformer = new SimpleNumberTransformer();
        String afterFormat = numberTransformer.toFormat(testList);
        System.out.println(afterFormat + " -- by StringBuilder");
    }
}