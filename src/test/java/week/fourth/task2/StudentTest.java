package week.fourth.task2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import week.fourth.task2.impl.BinaryTree;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentTest {

    private Student studentOne = new Student("Andrew");
    private Student studentTwo = new Student("Olga");

    {
        studentOne.addInfo("Mathematics", 5);
        studentOne.addInfo("Physics", 4);
        studentOne.addInfo("Biology", 7);
        studentOne.addInfo("English", 6);
        studentTwo.addInfo("Mathematics", 9);
        studentTwo.addInfo("Physics", 8);
        studentTwo.addInfo("Biology", 10);
        studentTwo.addInfo("English", 9);
    }

    private BinaryTree<Student> binaryTree = new BinaryTree<>();
    private StudentsService studentsService = new StudentsService();

    @BeforeEach
    void init() {
        binaryTree.add(studentOne);
        binaryTree.add(studentTwo);
    }

    @Test
    public void getTotalAvgTest() {
        Double expectedAvg = 6.375;
        Double actualAvg = studentsService.getTotalAvg(binaryTree);
        assertEquals(expectedAvg, actualAvg);
    }
    @Test
    public void getHighLevelStudentNameTest(){
        String expectedName = "Olga";
        String actualName = studentsService.getHighLevelStudentName(binaryTree);
        assertEquals(expectedName,actualName);

    }
}