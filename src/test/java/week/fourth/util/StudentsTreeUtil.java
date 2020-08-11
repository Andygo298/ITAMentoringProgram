package week.fourth.util;

import week.fourth.task2.Student;
import week.fourth.task2.impl.BinaryTree;

public class StudentsTreeUtil {

    public static BinaryTree<Student> buildTestStudentsTree(){

        BinaryTree<Student> binaryTree = new BinaryTree<>();

        Student studentOne = new Student("Andrew");
        Student studentTwo = new Student("Olga");
        Student studentThree = new Student("Sergei");
        Student studentFour = new Student("Ivan");
        Student studentFive = new Student("Petr");

        studentOne.addInfo("Mathematics", 5);
        studentOne.addInfo("Physics", 4);
        studentOne.addInfo("Biology", 5);
        studentOne.addInfo("English", 6);
        studentTwo.addInfo("Mathematics", 9);
        studentTwo.addInfo("Physics", 8);
        studentTwo.addInfo("Biology", 10);
        studentTwo.addInfo("English", 9);
        studentThree.addInfo("Mathematics", 5);
        studentThree.addInfo("Physics", 5);
        studentThree.addInfo("Biology", 9);
        studentThree.addInfo("English", 7);
        studentFour.addInfo("Mathematics", 4);
        studentFour.addInfo("Physics", 3);
        studentFour.addInfo("Biology", 4);
        studentFour.addInfo("English", 5);
        studentFive.addInfo("Mathematics", 8);
        studentFive.addInfo("Physics", 9);
        studentFive.addInfo("Biology", 10);
        studentFive.addInfo("English", 10);

        binaryTree.add(studentThree);
        binaryTree.add(studentOne);
        binaryTree.add(studentFive);
        binaryTree.add(studentFour);
        binaryTree.add(studentTwo);

        return binaryTree;
    }
}
