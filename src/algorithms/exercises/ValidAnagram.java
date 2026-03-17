package algorithms.exercises;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

/*  Given two strings s and t, return true if t is an anagram of s, and false otherwise.

    Example 1:

    Input: s = "anagram", t = "nagaram"

    Output: true

    Example 2:

    Input: s = "rat", t = "car"

    Output: false

    Constraints:

    1 <= s.length, t.length <= 5 * 104
    s and t consist of lowercase English letters.


    Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?*/

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram")); // true
        System.out.println(isAnagram("rat", "car")); // false

        System.out.println(isAnagram2("résumé", "sérumé")); // true
        System.out.println(isAnagram2("😊👍", "👍😊"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] counts = new int[26]; // One slot for each lowercase letter

        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
            counts[t.charAt(i) - 'a']--;
        }

        for (int count : counts) {
            if (count != 0)
                return false;
        }

        return true;
    }

    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length())
            return false;

        Map<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        for (char ch : t.toCharArray()) {
            if (!map.containsKey(ch))
                return false;

            map.put(ch, map.get(ch) - 1);
            if (map.get(ch) == 0)
                map.remove(ch);
        }

        return map.isEmpty();
    }

}
