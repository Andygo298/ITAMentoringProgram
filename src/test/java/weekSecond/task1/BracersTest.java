package weekSecond.task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BracersTest {

    private Bracers bracers = new Bracers();
    private final String exampleOne = "";
    private final String exampleTwo = "()";
    private final String exampleThree = "(){}[]";
    private final String exampleFour = "(]";
    private final String exampleFive = "([)]";
    private final String exampleSix = "{[]}";

    @Test
    void isCorrectTest() {
        assertAll(
                () -> assertTrue(bracers.isCorrect(exampleOne)),
                () -> assertTrue(bracers.isCorrect(exampleTwo)),
                () -> assertTrue(bracers.isCorrect(exampleThree)),
                () -> assertFalse(bracers.isCorrect(exampleFour)),
                () -> assertFalse(bracers.isCorrect(exampleFive)),
                () -> assertTrue(bracers.isCorrect(exampleSix))
        );
    }
}