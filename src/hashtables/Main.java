package hashtables;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {


    private static char findFirstNonRepeatingCharacter(String string) {
        string = string.replace(" ", "");

        char[] chars = string.toCharArray();
        int count;

        for(int i = 0; i < chars.length; i++){
            count = 0;
            for(int j = 0; j < chars.length; j++){
                if(i == j) {
                    continue;
                }
                if(chars[i] == chars[j]){
                    count++;
                    break;
                }
            }
            if(count == 0) {
                return chars[i];
            }
        }
        return '/';
    }

    private static char findFirstNonRepeatingChar(String string) {

        Map<Character, Integer> map = new HashMap<>();

        char[] chars = string.toCharArray();

        for(var ch : chars) {
            var count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch, count + 1);
        }

        for (var ch : chars) {
            if(map.get(ch) == 1)
                return ch;
        }
        return Character.MIN_VALUE;
    }

    private static char findFirstRepeatingCharacter(String string) {

        Map<Character, Integer> map = new HashMap<>();

        char[] chars = string.toCharArray();

        for(var ch : chars) {
            var count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch, count + 1);
            if(count + 1 == 2) {
                return ch;
            }
        }
        return Character.MIN_VALUE;
    }

    private static char findFirstRepeatingChar(String string) {
        Set<Character> set = new HashSet<>();

        for(var ch : string.toCharArray()) {
            if(set.contains(ch))
                return ch;

            set.add(ch);
        }
        return Character.MIN_VALUE;
    }
}
