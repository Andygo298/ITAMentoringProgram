package weekSecond.task1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Bracers {

    private Map<Character, Character> bracersMap = new HashMap<>();
    private Deque<Character> characters = new ArrayDeque<>();

    {
        bracersMap.put('(', ')');
        bracersMap.put('{', '}');
        bracersMap.put('[', ']');
    }

    public boolean isCorrect(String stringToCheck) {
        characters.clear();
        if (stringToCheck == null) {
            return false;
        } else {
            if (stringToCheck.isEmpty()) {
                return true;
            }
            for (int i = 0; i < stringToCheck.length(); i++) {
                Character currentChar = stringToCheck.charAt(i);
                if (bracersMap.containsKey(currentChar)) {
                    characters.add(currentChar);
                } else {
                    Character characterLast = bracersMap.get(characters.peekLast());
                    if (characterLast.equals(currentChar)) {
                        characters.pollLast();
                    }
                }
            }
        }
        return characters.isEmpty();
    }
}

