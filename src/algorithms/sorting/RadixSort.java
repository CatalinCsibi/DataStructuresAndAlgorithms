package algorithms.sorting;

/*
Initial array:
        [170, 45, 75, 90, 802, 24, 2, 66]

Step 1: Sort by least significant digit (units place)
Digits:       0   5   5   0   2   4   2   6
Sorted array: [170, 90, 802, 2, 24, 45, 75, 66]

Step 2: Sort by next digit (tens place)
Digits:       7   9   0   0   2   4   7   6
Sorted array: [802, 2, 24, 45, 66, 170, 75, 90]

Step 3: Sort by next digit (hundreds place)
Digits:       8   0   0   0   0   1   0   0
Sorted array: [2, 24, 45, 66, 75, 90, 170, 802]

Result: Fully sorted array
[2, 24, 45, 66, 75, 90, 170, 802]

Explanation:

At each step, we sort numbers based on the digit in a particular place, starting from the rightmost digit.

We use a stable sort at each step (like counting sort) so that the order of elements with the same digit stays consistent.

After sorting by the units place, we move on to the tens place, then hundreds, and so forth until all digits are processed.

This way, numbers gradually get sorted from least significant digit to most significant digit, resulting in a fully
sorted array at the end.
*/

public class RadixSort {

    public static void main(String[] args) {
        int[] array = {170, 45, 75, 90, 802, 24, 2, 66};

        // 0 5 5 0 2 4 2 6 -> 170 90 802 2 24  45  75  66
        // 7 9 0 0 2 4 7 6 -> 802 2 24 45 66 170 75 90
        // 8 0 0 0 0 1 0 0 -> 2 24 45 66 75 90 170 802

        System.out.println("Before sorting:");
        for (int num : array) System.out.print(num + " ");
        System.out.println();

        radixSort(array);

        System.out.println("After radix sort:");
        for (int num : array) System.out.print(num + " ");
    }

    // A utility function to get the maximum value in the array
    private static int getMax(int[] array) {
        int max = array[0];
        for (int num : array) {
            if (num > max) max = num;
        }
        return max;
    }

    // A function to do counting sort of array[] according to the digit represented by exp (10^i)
    private static void countingSortByDigit(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n]; // output array
        int[] count = new int[10]; // count array for digits 0-9

        // Store count of occurrences in count[]
        for (int i = 0; i < n; i++) {
            int digit = (array[i] / exp) % 10;
            count[digit]++;
        }

        // Change count[i] so that count[i] contains actual position of this digit in output[]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array (iterate from right to left for stability)
        for (int i = n - 1; i >= 0; i--) {
            int digit = (array[i] / exp) % 10;
            output[count[digit] - 1] = array[i];
            count[digit]--;
        }

        // Copy the output array to array[], so that array[] now contains sorted numbers according to current digit
        System.arraycopy(output, 0, array, 0, n);
    }

    // The main function to that sorts array[] using Radix Sort
    public static void radixSort(int[] array) {
        int max = getMax(array);

        // Do counting sort for every digit (exp = 1, 10, 100, ...)
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(array, exp);
        }
    }

}

