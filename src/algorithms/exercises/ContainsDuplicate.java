package algorithms.exercises;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
/*
    Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.



    Example 1:

    Input: nums = [1,2,3,1]
    Output: true
    Explanation:
    The element 1 occurs at the indices 0 and 3.

    Example 2:
    Input: nums = [1,2,3,4]
    Output: false
    Explanation:
    All elements are distinct.

    Example 3:
    Input: nums = [1,1,1,3,3,4,3,2,4,2]
    Output: true

    Constraints:

    1 <= nums.length <= 105
    -109 <= nums[i] <= 109*/

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,1};
        int[] nums2 = {1,2,3,4};

        System.out.println(containsDuplicate(nums1));
        System.out.println(containsDuplicate(nums2));

    }

    private static boolean containsDuplicate(int[] array) {
        Set<Integer> seen = new HashSet<>();
        for (int num : array) {
            if (!seen.add(num)) // add returns false if already exists
                return true;
        }
        return false;
    }
}
