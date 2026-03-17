package algorithms.recursion;

import java.util.HashMap;
import java.util.Map;

public class FibonacciExample {

    static int calculations = 0;

    public static void main(String[] args) {
        System.out.println("Slow: " + fibonacci(35)); // Brute-force

        FibonacciMaster fasterFib = new FibonacciMaster();
        System.out.println("DP (Memoization): " + fasterFib.fib(100)); // Memoization (Top-Down)

        System.out.println("DP2 (Bottom-Up): " + fibonacciMaster2(100)); // Tabulation (Bottom-Up)

        System.out.println("We did " + calculations + " calculations.");
    }

    // O(2^n) - Simple recursive Fibonacci (inefficient)
    public static int fibonacci(int n) {
        if (n < 2) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // O(n) - Memoized Fibonacci (Top-Down DP)
    public static class FibonacciMaster {
        private Map<Integer, Integer> cache = new HashMap<>();

        public int fib(int n) {
            calculations++;
            if (cache.containsKey(n)) return cache.get(n);

            int result;
            if (n < 2) {
                result = n;
            } else {
                result = fib(n - 1) + fib(n - 2);
            }
            cache.put(n, result);
            return result;
        }
    }

    // O(n) - Bottom-Up Dynamic Programming (Tabulation)
    public static int fibonacciMaster2(int n) {
        if (n < 2) return n;
        int[] fibArray = new int[n + 1];
        fibArray[0] = 0;
        fibArray[1] = 1;

        for (int i = 2; i <= n; i++) {
            fibArray[i] = fibArray[i - 1] + fibArray[i - 2];
        }
        return fibArray[n];
    }

}
