package weekFirst.task1.impl;

import weekFirst.task1.NumberTransformer;

import java.util.List;

public class SimpleNumberTransformer implements NumberTransformer {
    @Override
    public String toFormat(List<Integer> numbersList) {
        StringBuilder sb = new StringBuilder();
        numbersList.forEach(sb::append);
        sb.insert(0,"(").insert(4,") ").insert(9,"-");
        return sb.toString();
    }
}
