package algorithms.recursion;

public class ReverseStringExample {


    public static void main(String[] args) {
        System.out.println(reverseStringIterative("olleH"));
        System.out.println(reverseStringRecursive("olleH"));
    }

    private static String reverseStringRecursive(String s) {
        if (s.isEmpty()) {
            return "";
        } else {
            return reverseStringRecursive(s.substring(1)) + s.charAt(0);
        }
    }


    private static String reverseStringIterative(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = s.toCharArray();
        for(int i = chars.length-1; i >=0; i--) {
            stringBuilder.append(chars[i]);
        }
        return stringBuilder.toString();
    }
}
