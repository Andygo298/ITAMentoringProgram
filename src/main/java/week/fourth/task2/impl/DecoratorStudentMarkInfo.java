package week.fourth.task2.impl;

import lombok.Getter;
import week.fourth.task2.Student;
import week.fourth.task2.Visitor;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;


public class DecoratorStudentMarkInfo<V> extends StudentMarkInfo<V> {

    private Visitor<V> component;
    @Getter
    private List<Double> listCertificates = new ArrayList<>();

    public DecoratorStudentMarkInfo(Visitor<V> component) {
        this.component = component;
    }

    @Override
    public void visit(V value) {
        component.visit(value);
        Student student = (Student) value;
        OptionalDouble average = student.getStudentInfo()
                .values()
                .stream()
                .mapToDouble(mark -> mark)
                .average();
        listCertificates.add(average.isPresent() ? average.getAsDouble() : 0.0);
    }
}

