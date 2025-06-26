package algorithms.exercises;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {

/*    Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

    You must implement a solution with a linear runtime complexity and use only constant extra space.



    Example 1:
    Input: nums = [2,2,1]
    Output: 1

    Example 2:
    Input: nums = [4,1,2,1,2]
    Output: 4

    Example 3:
    Input: nums = [1]
    Output: 1*/

    public static void main(String[] args) {
        int[] array = {4,1,2,1,2};
        System.out.println(getSingleNumber(array));
        System.out.println(singleNumber(array));
    }


/*  Key XOR properties:

    a ^ a = 0 — a number XOR itself is 0

    a ^ 0 = a — a number XOR 0 is the number itself

    XOR is commutative and associative:

    a ^ b ^ c = c ^ b ^ a
*/
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;  // XOR accumulates
        }
        return result;
    }

    private static int getSingleNumber(int [] array) {
        Set<Integer> integers = new HashSet<>();
        for(int number : array) {
            if(integers.contains(number)) {
                integers.remove(number);
            } else {
                integers.add(number);
            }
        }
        return integers.iterator().next();
    }
}
