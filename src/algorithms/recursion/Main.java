package algorithms.recursion;

import java.util.HashSet;
import java.util.Set;

public class Main {

    private static long[] fibonacciCache;

    public static void main(String[] args) {

        int n = 8;

        System.out.println(factorialRecursive(5));
        System.out.println(reverseStringRecursive("hello"));
        System.out.println(reverseStringIterative("hello"));

        fibonacciCache = new long[n + 1];

        System.out.println(fibonacciRecursive2(n));

    }

    // Factorial algorithm
    private static int factorialRecursive(int number) {
        if(number == 2)
            return 2;

        return number * factorialRecursive(number -1);
    }

    private static int factorialIterative(int number) {
        for(int i = number-1; i > 0; i--) {
            number = number * i;
        }
        return number;
    }

    //Fibonacci algorithm
    private static int fibonacciRecursive(int n) { // O(2^n)
        if (n < 2)
            return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    private static long fibonacciRecursive2(int n) { // O(n)
        if (n < 2)
            return n;

        if(fibonacciCache[n] != 0)
            return fibonacciCache[n];

        long nthFibonacciNumber = fibonacciRecursive2(n - 1) + fibonacciRecursive2(n - 2);
        fibonacciCache[n] = nthFibonacciNumber;
        return nthFibonacciNumber;
    }


    private static int fibonacciIterative(int n) { // O(n)
        if (n < 2) return n;

        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n];
    }


    // Reverse a string algorithm
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

    private static void countDown(int n) {
        if (n == 0) {
            System.out.println("Done!");
            return;
        }
        System.out.println(n);
        countDown(n - 1); // Recursive call
    }

    private static int firstRecurringCharacter(int [] numbers) {
        Set<Integer> set = new HashSet<>();
        for (int number : numbers) {
            if (set.contains(number)) {
                return number;
            } else {
                set.add(number);
            }
        }
        return -1;
    }
}