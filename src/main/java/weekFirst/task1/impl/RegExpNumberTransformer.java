package weekFirst.task1.impl;

import weekFirst.task1.NumberTransformer;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpNumberTransformer implements NumberTransformer {
    @Override
    public String toFormat(List<Integer> numbersList) {
        StringBuilder sb = new StringBuilder();
        numbersList.forEach(sb::append);

        String regExp = "(\\d{3})(\\d{3})(\\d{4})";
        Pattern pattern = Pattern.compile(regExp);

        StringBuilder sbOut = new StringBuilder();
        Matcher matcher = pattern.matcher(sb.toString());

        while (matcher.find()) {
            String group1 = matcher.group(1);
            String group2 = matcher.group(2);
            String group3 = matcher.group(3);
            sbOut.append("(").append(group1).append(") ").append(group2).append("-").append(group3);
        }
        return sbOut.toString();
    }
}
