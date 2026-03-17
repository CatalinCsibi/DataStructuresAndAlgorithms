package algorithms.recursion;

public class FactorialExample {

    public static void main(String[] args) {
        System.out.println(factorialIterative(5));
        System.out.println(factorialRecursive(5));
    }


    private static int factorialRecursive(int number) {
        if(number < 2)
            return 1;

        return number * factorialRecursive(number -1);
    }

    private static int factorialIterative(int number) {
       int result = 1;
       for(int i = 2; i <= number; i++) {
           result *= i;
       }
       return result;
    }
}
