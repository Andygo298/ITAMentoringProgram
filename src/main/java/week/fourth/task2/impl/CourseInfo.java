package week.fourth.task2.impl;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public abstract class CourseInfo {

    protected Map<Double, String> studentsCertificates = new HashMap<>();
    @Getter
    protected String highLevelStudentName;

}
