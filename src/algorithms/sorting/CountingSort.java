package algorithms.sorting;

public class CountingSort {


    public static void main(String[] args) {
        int[] array = {4, 2, 2, 8, 3, 3, 1};

        System.out.println("Before sorting:");
        for (int num : array) System.out.print(num + " ");
        System.out.println();

        countingSort(array);

        System.out.println("After counting sort:");
        for (int num : array) System.out.print(num + " ");
    }

    public static void countingSort(int[] array) {
        if (array.length == 0) return;

        // Step 1: Find max value in the array
        int max = array[0];
        for (int num : array) {
            if (num > max) max = num;
        }

        // Step 2: Create count array and count occurrences
        int[] count = new int[max + 1];
        for (int num : array) {
            count[num]++;
        }

        // Step 3: Modify count array to store cumulative counts
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Step 4: Build the output sorted array
        int[] output = new int[array.length];
        // Traverse input array from right to left for stable sort
        for (int i = array.length - 1; i >= 0; i--) {
            int num = array[i];
            count[num]--;
            output[count[num]] = num;
        }

        // Step 5: Copy the sorted elements back to original array
        System.arraycopy(output, 0, array, 0, array.length);
    }
}

