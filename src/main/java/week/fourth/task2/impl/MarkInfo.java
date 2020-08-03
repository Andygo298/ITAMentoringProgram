package week.fourth.task2.impl;

import lombok.Getter;
import week.fourth.task2.Student;
import week.fourth.task2.Visitor;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

@Getter
public class MarkInfo implements Visitor {

    private List<Integer> listAllMarks = new ArrayList<>();
    private List<Double> certificates = new ArrayList<>();


    @Override
    public void visit(Student student) {
        listAllMarks.addAll(student.getStudentInfo().values());
        OptionalDouble average = listAllMarks.stream().mapToDouble(elem -> elem).average();
        certificates.add(average.isPresent() ? average.getAsDouble() : 0.0);
    }
}
