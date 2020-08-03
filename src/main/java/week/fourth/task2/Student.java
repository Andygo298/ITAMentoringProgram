package week.fourth.task2;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@RequiredArgsConstructor
public class Student implements Comparable<Student>, Element {

    @NonNull
    private String name;

    private Map<String, Integer> studentInfo = new HashMap<>();

    public void addInfo(String nameCourse,Integer mark) {
        this.studentInfo.put(nameCourse, mark);
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.hashCode(), o.hashCode());
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
