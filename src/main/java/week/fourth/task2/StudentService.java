package week.fourth.task2;

import week.fourth.task2.enums.Strategy;
import week.fourth.task2.impl.*;

import java.util.Iterator;
import java.util.List;

public class StudentService {

    public List<Integer> getAllStudentsMarks(BinaryTree<Student> binaryTree) {
        StudentMarkInfo<Student> studentMarkInfo = new StudentMarkInfo<>();

        binaryTree.setSearchStrategy(Strategy.DEPTH_FIRST_SEARCH_PRE_ORDER);
        Iterator<Student> iterator = binaryTree.iterator();
        iterator.forEachRemaining(studentMarkInfo::visit);
        return studentMarkInfo.getListAllMarks();
    }

    public Double getTotalAvg(BinaryTree<Student> binaryTree) {
        DecoratorStudentMarkInfo<Student> decoratorMarkInfo = new DecoratorStudentMarkInfo<>(new StudentMarkInfo<>());

        binaryTree.setSearchStrategy(Strategy.BREADTH_FIRST_SEARCH);
        Iterator<Student> iterator = binaryTree.iterator();
        iterator.forEachRemaining(decoratorMarkInfo::visit);
        return decoratorMarkInfo.getListCertificates().stream()
                .mapToDouble(elem -> elem)
                .average()
                .orElse(0.0);
    }

    public String getHighLevelStudentName(BinaryTree<Student> binaryTree) {
        StudentCourseInfo<Student> studentCourseInfo = new StudentCourseInfo<>();

        binaryTree.setSearchStrategy(Strategy.DEPTH_FIRST_SEARCH_PRE_ORDER);
        Iterator<Student> iterator = binaryTree.iterator();
        iterator.forEachRemaining(studentCourseInfo::visit);

        studentCourseInfo.calcHighStudentCertificate();
        Double highLevelCertificate = studentCourseInfo.getHighLevelCertificate();

        return studentCourseInfo.getStudentsCertificates().get(highLevelCertificate);
    }

    public String getLowLevelStudentName(BinaryTree<Student> binaryTree) {

        DecoratorStudentCourseInfo<Student> decoratorStudentCourseInfo = new DecoratorStudentCourseInfo<>(new StudentCourseInfo<>());

        binaryTree.setSearchStrategy(Strategy.DEPTH_FIRST_SEARCH_PRE_ORDER);
        Iterator<Student> iterator = binaryTree.iterator();
        iterator.forEachRemaining(decoratorStudentCourseInfo::visit);

        decoratorStudentCourseInfo.calcLowStudentCertificate();
        Double lowLevelCertificate = decoratorStudentCourseInfo.getLowLevelCertificate();

        return decoratorStudentCourseInfo.getStudentsCertificates().get(lowLevelCertificate);
    }
}
