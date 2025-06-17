package algorithms.sorting;

public class InsertionSort {
    public static void main(String[] args) {
        int[] numbers = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        insertionSort(numbers);

        // Print the sorted array
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }

    private static void insertionSort(int[] array) {
        int length = array.length;

        for (int i = 1; i < length; i++) { // Start from the second element
            int current = array[i]; // The element we want to insert
            int j = i - 1;

            // Find the position to insert the element by shifting larger elements to the right
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j]; // Shift element to the right
                j--;
            }
            // Insert the element at the correct position
            array[j + 1] = current;
        }
    }

    private static void insertionSort2(int[] array) {
        for(int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i -1;

            while(j >= 0 && array[j] > current) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = current;
        }
    }
}

