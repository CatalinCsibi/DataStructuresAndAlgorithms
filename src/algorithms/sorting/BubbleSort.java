package algorithms.sorting;


public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {5, 7, 3, 1, 10, 90, 65, 2};
        bubbleSort2(array);

        for(int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();

        String[] strings = {"Hello", "Bye", "Ciao", "Goodnight", "Goodbye", };
        bubbleSortStrings(strings);

        for(String s : strings) {
            System.out.print(s + " ");
        }

    }

    public static void bubbleSort(int[] array) {
        int length = array.length;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1; j++) { // Notice 'length - 1' to avoid ArrayIndexOutOfBounds
                if (array[j] > array[j + 1]) {
                    // Swap elements
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    private static void bubbleSortStrings(String[] array) {
        for(int i =0; i< array.length; i++) {
            for(int j = 0; j < array.length-1; j++) {
                if(array[j].compareTo(array[j+1]) > 0) {
                    String temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    public static void bubbleSort2(int[] array) {
        boolean swapped;
        for (int i = 0; i < array.length; i++) {
            swapped = false;
            for (int j = 0; j < array.length - 1 - i; j++) { // reduce comparisons each pass
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // array is sorted early
        }
    }



}
