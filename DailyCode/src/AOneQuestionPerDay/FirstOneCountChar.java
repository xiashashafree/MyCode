package AOneQuestionPerDay;

import java.util.HashMap;
import java.util.Map;

public class FirstOneCountChar {
    public char firstUniqChar(String s) {
        Map<Character,Boolean> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c,!map.containsKey(c));
        }

        for(char c:s.toCharArray()){
            if(map.get(c)) return c;
        }
        return ' ';
    }

}