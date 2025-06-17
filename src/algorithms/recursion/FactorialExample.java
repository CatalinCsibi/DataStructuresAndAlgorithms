package algorithms.recursion;

public class FactorialExample {

    public static void main(String[] args) {
        System.out.println(factorialIterative(5));
        System.out.println(factorialRecursive(5));
    }


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
}
