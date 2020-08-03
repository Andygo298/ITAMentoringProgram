package week.fourth.task2;

import week.fourth.task2.enums.Strategy;
import week.fourth.task2.impl.BinaryTree;
import week.fourth.task2.impl.CourseInfo;
import week.fourth.task2.impl.MarkInfo;

import java.util.Iterator;

public class StudentsService {

    public Double getTotalAvg(BinaryTree<Student> binaryTree) {
        MarkInfo markInfo = new MarkInfo();
        binaryTree.setSearchStrategy(Strategy.BREADTH_FIRST_SEARCH);
        Iterator<Student> iterator = binaryTree.iterator();

        while (iterator.hasNext()) {
            Student next = iterator.next();
            markInfo.visit(next);
        }

        return markInfo.getCertificates().stream()
                .mapToDouble(elem -> elem)
                .average()
                .orElse(0.0);
    }

    public String getHighLevelStudentName(BinaryTree<Student> binaryTree) {
        CourseInfo courseInfo = new CourseInfo();
        binaryTree.setSearchStrategy(Strategy.BREADTH_FIRST_SEARCH);
        Iterator<Student> iterator = binaryTree.iterator();

        while (iterator.hasNext()) {
            Student next = iterator.next();
            courseInfo.visit(next);
        }
        Double keyMaxAverage = courseInfo.getStudentsCertificates().keySet()
                .stream()
                .mapToDouble(key -> key)
                .max()
                .orElse(0.0);

        return courseInfo.getStudentsCertificates().get(keyMaxAverage);
    }
}
