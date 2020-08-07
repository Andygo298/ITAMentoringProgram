package week.fourth.task2.impl;

import week.fourth.task2.Student;
import week.fourth.task2.Visitor;


public class StudentMarkInfo<V> extends MarkInfo implements Visitor<V> {

    @Override
    public void visit(V value) {
        Student student = (Student) value;
        listAllMarks.addAll(student.getStudentInfo().values());
    }

}
