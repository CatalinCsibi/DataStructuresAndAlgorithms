package algorithms.exercises;

public class IsPalindrome {

    public static void main(String[] args) {
        System.out.println(isStringPalindrome("aabaa"));
        System.out.println(isStringPalindrome("hello"));
        System.out.println(isStringPalindrome2("aabaa"));
        System.out.println(isStringPalindrome2("hello"));
        System.out.println(isIntegerPalindrome(11211));
        System.out.println(isIntegerPalindrome(112113));
    }

    private static boolean isStringPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private static boolean isStringPalindrome2(String s) {
        char[] chars = s.toCharArray();
        int last = chars.length-1;
        for(int i = 0; i < chars.length/2; i++) {
            if(chars[i] != chars[last]){
                return false;
            }
            last--;
        }
        return true;
    }

    private static boolean isIntegerPalindrome(int num) {
        // Negative numbers and numbers ending in 0 (except 0 itself) can't be palindromes
        if (num < 0 || (num % 10 == 0 && num != 0)) {
            return false;
        }

        int reversedHalf = 0;

        while (num > reversedHalf) {
            int digit = num % 10;
            reversedHalf = reversedHalf * 10 + digit;
            num /= 10;
        }

        // For even length: num == reversedHalf
        // For odd length:  num == reversedHalf / 10 (middle digit ignored)
        return num == reversedHalf || num == reversedHalf / 10;
    }

}
