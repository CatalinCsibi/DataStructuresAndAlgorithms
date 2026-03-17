package algorithms.exercises;

import java.util.HashSet;
import java.util.Set;

public class MissingNumber {

 /* Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

    Example 1:
    Input: nums = [3,0,1]
    Output: 2

    Explanation:
    n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.

    Example 2:
    Input: nums = [0,1]
    Output: 2
    Explanation:
    n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.

    Example 3:
    Input: nums = [9,6,4,2,3,5,7,0,1]

    Output: 8
    Explanation:
    n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.*/

    public static void main(String[] args) {
        int[] nums1 = {3,0,1};
        int[] nums2 = {0,1};
        int[] nums3 = {9,6,4,2,3,5,7,0,1};

        System.out.println(missingNumber(nums1));
        System.out.println(missingNumber(nums2));
        System.out.println(missingNumber(nums3));
        System.out.println();

        System.out.println(missingNumber2(nums1));
        System.out.println(missingNumber2(nums2));
        System.out.println(missingNumber2(nums3));
        System.out.println();

        System.out.println(missingNumberXOR(nums1));
        System.out.println(missingNumberXOR(nums2));
        System.out.println(missingNumberXOR(nums3));


    }

    private static int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }

        for(int i =0; i<= nums.length; i++) {
            if(!set.contains(i))
                return i;
        }
        return -1;
    }

    public static int missingNumber2(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int num : nums) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }

    public static int missingNumberXOR(int[] nums) {
        int xor = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            xor ^= i ^ nums[i];
        }

        return xor ^ n;
    }

}
