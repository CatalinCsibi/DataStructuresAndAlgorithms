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

        // 4 ,3, 5, 1, 7

        // current = 3 ; j = 0;
        // 0>=0 && 4 > 3 -> array[1] = 4 -> j = -1;
        // array[0+1] = 3 -> 3, 4, 5, 1, 7

        // current = 5; j = 1;
        // 1 >= 0 && 4 > 5 -> false -> array[2] = 5;  -> 3, 4, 5, 1, 7

        // current = 1; j = 2
        // 2 >=0 && 5 > 1 -> array[3] = 5 -> j = 1
        // 1 >=0 && 4 > 1 -> array[2] = 4 -> j = 0;
        // 0 >=0 && 3 > 1 -> array[1] = 3 -> j = -1
        // array[-1 + 1] = 1 -> 1, 3, 4, 5, 7

        //current = 7; j = 3
        // 3 >= 0 && 5 > 7 -> false -> array[3+1] = 7

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

