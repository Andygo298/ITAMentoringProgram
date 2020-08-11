package week.fourth.task2.impl;

import lombok.Getter;
import week.fourth.task2.Student;
import week.fourth.task2.Visitor;

import java.util.ArrayList;
import java.util.List;


public class StudentMarkInfo<V> implements Visitor<V> {

    @Getter
    protected List<Integer> listAllMarks = new ArrayList<>();

    @Override
    public void visit(V value) {
        Student student = (Student) value;
        listAllMarks.addAll(student.getStudentInfo().values());
    }

}
