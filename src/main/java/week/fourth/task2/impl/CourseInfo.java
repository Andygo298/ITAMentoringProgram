package week.fourth.task2.impl;

import lombok.Getter;
import week.fourth.task2.Student;
import week.fourth.task2.Visitor;

import java.util.HashMap;
import java.util.Map;

@Getter
public class CourseInfo implements Visitor {

    private Map<Double, String> studentsCertificates = new HashMap<>();

    @Override
    public void visit(Student student) {
        Double average = student.getStudentInfo().values()
                .stream()
                .mapToDouble(elem -> elem)
                .average()
                .orElse(0.0);
        studentsCertificates.put(average, student.getName());
    }
}
