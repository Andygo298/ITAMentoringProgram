package week.fourth.task2.impl;

import lombok.Getter;
import week.fourth.task2.Student;
import week.fourth.task2.Visitor;

import java.util.HashMap;
import java.util.Map;

public class StudentCourseInfo<V> implements Visitor<V> {

    @Getter
    private Double highLevelCertificate;
    @Getter
    protected Map<Double, String> studentsCertificates = new HashMap<>();

    @Override
    public void visit(V value) {
        Student student = (Student) value;
        Double average = student.getStudentInfo().values()
                .stream()
                .mapToDouble(elem -> elem)
                .average()
                .orElse(0.0);
        studentsCertificates.put(average, student.getName());
    }

    public void calcHighStudentCertificate() {
        highLevelCertificate = studentsCertificates.keySet()
                .stream()
                .mapToDouble(key -> key)
                .max()
                .orElse(0.0);
    }

}
