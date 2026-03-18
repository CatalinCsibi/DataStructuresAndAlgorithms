package algorithms.exercises;

import java.util.HashSet;
import java.util.Set;

public class MissingBiggestNumber {

//    Write a function:
//
//    class Solution { public int solution(int[] A); }
//    content_copy
//
//    that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
//
//    For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
//
//    Given A = [1, 2, 3], the function should return 4.
//
//    Given A = [−1, −3], the function should return 1.
//
//    Write an efficient algorithm for the following assumptions:
//
//    N is an integer within the range [1..100,000];
//    each element of array A is an integer within the range [−1,000,000..1,000,000].

    public static void main(String[] args) {
        System.out.println(solutionWithSet(new int[]{1, 2, 3}));
    }


    public static int solution(int[] A) {
        int n = A.length;
        boolean[] present = new boolean[n + 1]; // track 1..n

        for (int value : A) {
            if (value > 0 && value <= n) {
                present[value] = true;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!present[i]) {
                return i;
            }
        }

        return n + 1;
    }

    public static int solutionWithSet(int[] A) {
        Set<Integer> set = new HashSet<>();

        for (int x : A) {
            if (x > 0) {
                set.add(x);
            }
        }

        for (int i = 1; i <= A.length + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return 1;
    }


}
