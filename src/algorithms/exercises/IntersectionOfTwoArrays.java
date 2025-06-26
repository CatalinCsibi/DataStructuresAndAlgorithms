package algorithms.exercises;

import java.util.*;

public class IntersectionOfTwoArrays {

 /* Given two integer arrays nums1 and nums2, return an array of their intersection.
    Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

    Example 1:
    Input: nums1 = [1,2,2,1], nums2 = [2,2]
    Output: [2,2]

    Example 2:
    Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    Output: [4,9]
    Explanation: [9,4] is also accepted.


   Constraints:

   1 <= nums1.length, nums2.length <= 1000
   0 <= nums1[i], nums2[i] <= 1000


    Follow up:

    What if the given array is already sorted? How would you optimize your algorithm?
    What if nums1's size is small compared to nums2's size? Which algorithm is better?
    What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?*/

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums11 = {2,2};
        int[] nums2 = {4,9,5};
        int[] nums22 = {9,4,9,8,4};


        System.out.println(Arrays.toString(intersect(nums1, nums11)));
        System.out.println(Arrays.toString(intersect(nums2, nums22)));

    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> intersection = new ArrayList<>();
        for (int num : nums2) {
            if (map.getOrDefault(num, 0) > 0) {
                intersection.add(num);
                map.put(num, map.get(num) - 1);
            }
        }

        // Convert List<Integer> to int[]
        int[] result = new int[intersection.size()];
        for (int i = 0; i < intersection.size(); i++) {
            result[i] = intersection.get(i);
        }
        return result;
    }
}
