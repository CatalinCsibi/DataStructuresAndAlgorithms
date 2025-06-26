package algorithms.exercises;

public class SumOfTwoIntegers {

/*    Given two integers a and b, return the sum of the two integers without using the operators + and -.

    Example 1:

    Input: a = 1, b = 2
    Output: 3
    Example 2:

    Input: a = 2, b = 3
    Output: 5


    Constraints:
    -1000 <= a, b <= 1000*/

    public static void main(String[] args) {
        System.out.println(sumOfTwoIntegers(2, 3));
    }

    private static int sumOfTwoIntegers(int a, int b) {
        if(a < - 1000 || b > 1000)
            throw new IllegalArgumentException();

        while (b != 0) {
            int carry = (a & b) << 1; // Calculate carry
            a = a ^ b;                // Sum without carry
            b = carry;                // Add carry in next round
        }
        return a;
    }
}
