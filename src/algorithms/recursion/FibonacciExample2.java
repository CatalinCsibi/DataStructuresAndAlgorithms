package algorithms.recursion;

public class FibonacciExample2 {


    private static long[] fibonacciCache;

    public static void main(String[] args) {

        int n = 8;

        fibonacciCache = new long[n + 1];

        System.out.println(fibonacciRecursive2(n));
        System.out.println(fibonacciIterative(n));

    }

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
}
