package algorithms.recursion;

public class BasicRecursionExample {

    public static void main(String[] args) {
        countDown(5);
    }

    private static void countDown(int n) {
        if (n == 0) {
            System.out.println("Done!");
            return;
        }
        System.out.println(n);
        countDown(n - 1); // Recursive call
    }
}
