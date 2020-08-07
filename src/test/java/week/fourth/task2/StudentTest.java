package week.fourth.task2;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import week.fourth.task2.impl.BinaryTree;
import week.fourth.util.StudentsTreeUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class StudentTest {

    private StudentsService studentsService = new StudentsService();

    @Test
    public void getTotalAvgGoodTest() {
        BinaryTree<Student> binaryTree = StudentsTreeUtil.buildTestStudentsTree();
        Double expectedAvg = 6.435;
        Double actualAvg = studentsService.getTotalAvg(binaryTree);
        assertEquals(expectedAvg, actualAvg);
    }

    @Test
    public void getTotalAvgBadTest() {
        BinaryTree<Student> binaryTree = StudentsTreeUtil.buildTestStudentsTree();
        Double expectedAvg = 5.385;
        Double actualAvg = studentsService.getTotalAvg(binaryTree);
        assertNotEquals(expectedAvg, actualAvg);
    }

    @Test
    public void getHighLevelStudentNameGoodTest() {
        BinaryTree<Student> binaryTree = StudentsTreeUtil.buildTestStudentsTree();
        String expectedName = "Petr";
        String actualName = studentsService.getHighLevelStudentName(binaryTree);
        assertEquals(expectedName, actualName);
    }

    @Test
    public void getHighLevelStudentNameBadTest() {
        BinaryTree<Student> binaryTree = StudentsTreeUtil.buildTestStudentsTree();
        String expectedName = "Olga";
        String actualName = studentsService.getHighLevelStudentName(binaryTree);
        assertNotEquals(expectedName, actualName);
    }

    @Test
    public void getAllMarksStudentsGoodTest() {
        BinaryTree<Student> binaryTree = StudentsTreeUtil.buildTestStudentsTree();
        List<Integer> expectedList = new ArrayList<>(Arrays.asList(7, 5, 9, 4, 6, 5, 7, 4, 10, 8, 10, 9, 5, 4, 4, 3, 9, 9, 10, 8));
        List<Integer> allStudentsMarks = studentsService.getAllStudentsMarks(binaryTree);
        assertThat(allStudentsMarks, Matchers.hasSize(20));
        assertEquals(expectedList, allStudentsMarks);
    }

    @Test
    public void getAllMarksStudentsBadTest() {
        BinaryTree<Student> binaryTree = StudentsTreeUtil.buildTestStudentsTree();
        List<Integer> expectedList = new ArrayList<>(Arrays.asList(7, 5, 10, 4, 6, 5, 4, 4, 10, 8, 5, 9, 5, 4, 8, 3, 5, 9, 10, 8));
        List<Integer> allStudentsMarks = studentsService.getAllStudentsMarks(binaryTree);
        assertThat(allStudentsMarks, Matchers.hasSize(20));
        assertNotEquals(expectedList, allStudentsMarks);
    }
}