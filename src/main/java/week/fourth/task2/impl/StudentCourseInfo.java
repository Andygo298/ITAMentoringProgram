package week.fourth.task2.impl;

import week.fourth.task2.Student;
import week.fourth.task2.Visitor;

public class StudentCourseInfo<V> extends CourseInfo implements Visitor<V> {

    @Override
    public void visit(V value) {
        Student student = (Student) value;
        Double average = student.getStudentInfo().values()
                .stream()
                .mapToDouble(elem -> elem)
                .average()
                .orElse(0.0);
        studentsCertificates.put(average, student.getName());

        Double keyMaxAverage = studentsCertificates.keySet()
                .stream()
                .mapToDouble(key -> key)
                .max()
                .orElse(0.0);

        highLevelStudentName = (studentsCertificates.get(keyMaxAverage));
    }
}
