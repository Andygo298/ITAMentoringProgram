package week.fourth.task2.impl;

import lombok.Getter;
import week.fourth.task2.Visitor;

public class DecoratorStudentCourseInfo<V> extends StudentCourseInfo<V>{

    Visitor<V> component;
    @Getter
    private Double lowLevelCertificate;

    public DecoratorStudentCourseInfo(Visitor<V> component) {
        this.component = component;
    }

    @Override
    public void visit(V value) {
        super.visit(value);
    }

    public void calcLowStudentCertificate() {
        lowLevelCertificate = studentsCertificates.keySet()
                .stream()
                .mapToDouble(key -> key)
                .min()
                .orElse(0.0);
    }
}
