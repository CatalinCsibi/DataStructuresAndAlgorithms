package algorithms.exercises;

import java.util.ArrayList;
import java.util.Arrays;

public class MoveZeroes {

/*    Move Zeroes
    Hint
    Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

    Note that you must do this in-place without making a copy of the array.



    Example 1:

    Input: nums = [0,1,0,3,12]
    Output: [1,3,12,0,0]
    Example 2:

    Input: nums = [0]
    Output: [0]


    Constraints:

            1 <= nums.length <= 104
            -231 <= nums[i] <= 231 - 1


    Follow up: Could you minimize the total number of operations done?*/

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};

        System.out.println(Arrays.toString(moveZeroes(nums)));


    }

    private static int[] moveZeroes(int[] nums) {
        int count = 0;
        for(int number : nums) {
            if(number != 0) {
                nums[count++] = number;
            }
        }
        while (count < nums.length) {
            nums[count++] = 0;
        }
        return nums;
    }

    private static int[] moveZeroes2(int[] nums) {
        ArrayList<Integer> integers = new ArrayList<>(nums.length);
        int count = 0;
        for(int number : nums) {
            if(number == 0) {
                count++;
            } else {
                integers.add(number);
            }
        }
        while (count != 0) {
            integers.add(0);
            count--;
        }
        return integers.stream().mapToInt(Integer::intValue).toArray();
    }


}
