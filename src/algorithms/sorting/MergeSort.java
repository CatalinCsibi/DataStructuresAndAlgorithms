package algorithms.sorting;

import java.util.Arrays;

/* Split:         [38,27,43,3,9,82,10]
                   /              \
            [38,27,43,3]         [9,82,10]
             /      \             /    \
         [38,27]    [43,3]     [9,82]   [10]
          /   \      /  \      /   \
        [38] [27] [43] [3]   [9] [82]   [10]
*/

/* Merge process:

        [38] + [27] → [27,38]
        [43] + [3]  → [3,43]
        [9] + [82]  → [9,82]

        [27,38] + [3,43] → [3,27,38,43]
        [9,82] + [10]   → [9,10,82]

Final Merge:
        [3,27,38,43] + [9,10,82] → [3,9,10,27,38,43,82]

*/


public class MergeSort {
    public static void main(String[] args) {
        int[] numbers = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        numbers = mergeSort(numbers);

        // Print the sorted array
        System.out.println(Arrays.toString(numbers));
    }

    public static int[] mergeSort(int[] array) {

        // Base case: if the array has only one element, return it
        if (array.length == 1) {
            return array;
        }

        int middle = array.length / 2;

        // Split array into left and right halves
        int[] left = Arrays.copyOfRange(array, 0, middle);
        int[] right = Arrays.copyOfRange(array, middle, array.length);

        // Recursive sort and merge
        return merge(mergeSort(left), mergeSort(right));
    }

    public static int[] mergeSort2(int[] array) {
        if (array.length == 1) {
            return array;
        }

        int middle = array.length / 2;

        // Manually copy left half
        int[] left = new int[middle];
        for (int i = 0; i < middle; i++) {
            left[i] = array[i];
        }

        // Manually copy right half
        int[] right = new int[array.length - middle];
        for (int i = middle; i < array.length; i++) {
            right[i - middle] = array[i];
        }

        return merge(mergeSort(left), mergeSort(right));
    }
    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int leftIndex = 0, rightIndex = 0, resultIndex = 0;

        // Merge while both arrays have elements
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                result[resultIndex++] = left[leftIndex++];
            } else {
                result[resultIndex++] = right[rightIndex++];
            }
        }

        // Copy remaining elements from left
        while (leftIndex < left.length) {
            result[resultIndex++] = left[leftIndex++];
        }

        // Copy remaining elements from right
        while (rightIndex < right.length) {
            result[resultIndex++] = right[rightIndex++];
        }

        return result;
    }
}

