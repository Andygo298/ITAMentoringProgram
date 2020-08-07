package week.fourth.task2;

import lombok.Getter;
import week.fourth.task2.impl.CourseInfo;

public class DecoratorStudentCourseInfo<V> extends CourseInfo implements Visitor<V> {

    private Visitor<V> component;
    @Getter
    private String lowLevelStudentName;

    public DecoratorStudentCourseInfo(Visitor<V> component) {
        this.component = component;
    }

    @Override
    public void visit(V value) {
        component.visit(value);
        Double keyMinAverage = studentsCertificates.keySet()
                .stream()
                .mapToDouble(key -> key)
                .min()
                .orElse(0.0);

        lowLevelStudentName = (studentsCertificates.get(keyMinAverage));
    }
}
