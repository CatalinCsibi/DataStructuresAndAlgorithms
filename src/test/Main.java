package test;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        System.out.println(reverseStringWithStack("Hello from"));
        System.out.println(reverseString("Hello from"));
        System.out.println(isPalindrome("12321"));

        System.out.println(recursiveSum(10));
    }

    private static String reverseStringWithStack(String s){
        char [] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for(char ch : chars)
            stack.push(ch);

        StringBuilder stringBuilder = new StringBuilder();

        while (!stack.isEmpty())
            stringBuilder.append(stack.pop());

        return stringBuilder.toString();
    }

    private static String reverseString(String s) {
        if(s.isEmpty())
            return "";

        return reverseString(s.substring(1)) + s.charAt(0);

    }

    public static boolean isPalindrome(String s) {
        if(s.length() == 0 || s.length() == 1)
            return true;

        if(s.charAt(0) == s.charAt(s.length() - 1))
            return isPalindrome(s.substring(1, s.length() -1));

        return false;
    }

    private static int recursiveSum(int number){
        if(number <= 1)
            return number;

        return number + recursiveSum(number -1);
    }

}
