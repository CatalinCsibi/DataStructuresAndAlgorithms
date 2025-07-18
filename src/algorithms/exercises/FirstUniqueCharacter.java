package algorithms.exercises;

public class FirstUniqueCharacter {

/*  Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

    Example 1:
    Input: s = "leetcode"
    Output: 0
    Explanation:
    The character 'l' at index 0 is the first character that does not occur at any other index.

    Example 2:
    Input: s = "loveleetcode"
    Output: 2

    Example 3:
    Input: s = "aabb"
    Output: -1

    Constraints:
    1 <= s.length <= 105
    s consists of only lowercase English letters.*/

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));
        System.out.println(firstUniqChar("aabb"));
    }

    public static int firstUniqChar(String s) {
        int[] count = new int[26];

        // First pass: count frequency of each character
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        // Second pass: find the first character with frequency 1
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1)
                return i;
        }

        return -1; // no unique character found
    }

}
