package stacks;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main {


    private static final List<Character> leftBrackets = Arrays.asList('(', '<', '[', '{');
    private static final List<Character> rightBrackets = Arrays.asList(')', '>', ']', '}');

    public static void main(String[] args) {

        ResizeableStack<String> resizeableStack = new ResizeableStack<>();

        resizeableStack.push("first");
        resizeableStack.push("second");
        resizeableStack.push("third");
        resizeableStack.push("fourth");
        resizeableStack.push("fifth");
        resizeableStack.push("sixth");
        resizeableStack.push("seventh");



        System.out.println(resizeableStack.peek());
        System.out.println(resizeableStack.pop());
        System.out.println(resizeableStack.pop());
        System.out.println(resizeableStack.pop());
        System.out.println(resizeableStack.pop());
        System.out.println(resizeableStack.pop());
        System.out.println(resizeableStack.isEmpty());

        System.out.println(resizeableStack);

    }

    //My Solution
    private static String reverseString(String s) {
        if(s == null)
            throw new IllegalArgumentException();

        char [] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for(char c : chars)
            stack.push(c);

        StringBuilder reverse = new StringBuilder();
        while (!stack.isEmpty()) {
            char c = stack.pop();
            reverse.append(c);
        }
        return reverse.toString();
    }

    private static String reverse(String input) {
        if(input == null)
            throw new IllegalArgumentException();

        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray())
            stack.push(ch);

        StringBuffer reversed = new StringBuffer();

        while (!stack.isEmpty())
            reversed.append(stack.pop());

        return reversed.toString();
    }

    //My solution
    private static boolean isStringBalanced(String input) {

        Stack<Character> stack = new Stack<>();

        for(char ch : input.toCharArray()) {
            if(ch == '{' || ch == '[' || ch == '(' || ch == '<')
                stack.push(ch);

            else if(ch == '}' && stack.pop() != '{') {
                return false;
            } else if(ch == ']' && stack.pop() != '['){
                return false;
            } else  if(ch == ')' && stack.pop() != '('){
                return false;
            } else if (ch == '>' && stack.pop() != '<'){
                return false;
            }
        }
        return true;
    }

    private static boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<>();

        for(char ch : input.toCharArray()) {
            if(isLeftBracket(ch))
                stack.push(ch);

            if(isRightBracket(ch)) {
                if( stack.empty()) return false;
                var top = stack.pop();
                if(bracketsDoNotMatch(top, ch))
                    return false;
            }
        }

        return stack.empty();
    }

    private static boolean isLeftBracket(char ch) {
        return leftBrackets.contains(ch);
    }

    private static boolean isRightBracket(char ch) {
        return rightBrackets.contains(ch);
    }

    private static boolean bracketsDoNotMatch(char left, char right) {
        return leftBrackets.indexOf(left) == rightBrackets.indexOf(right);
    }
}
