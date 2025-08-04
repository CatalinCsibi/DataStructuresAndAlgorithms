package algorithms.sorting;

public class SelectionSort {

    public static void main(String[] args) {

        int[] array = {5, 7, 3, 1, 10, 90, 65, 2};
        selectionSort3(array);

        for(int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();

        String[] strings = {"Hello", "Bye", "Ciao", "Goodnight", "Goodbye", };
        selectionSortStrings(strings);

        for(String s : strings) {
            System.out.print(s + " ");
        }

    }


    private static void selectionSortStrings(String[] strings) {
        for(int i = 0; i< strings.length-1; i++) {
            int min = i;
            String temp = strings[i];

            for(int j = i + 1; j < strings.length; j++) {
                if(strings[j].compareTo(strings[min]) < 0) {
                    min = j;
                }
            }
            strings[i] = strings[min];
            strings[min] = temp;
        }
    }


    public static void selectionSort(int[] array) {
        int length = array.length;

        for (int i = 0; i < length - 1; i++) {
            // Set current index as minimum
            int min = i;
            int temp = array[i];

            for (int j = i + 1; j < length; j++) {
                if (array[j] < array[min]) {
                    // Update minimum if current is lower than what we had previously
                    min = j;
                }
            }

            // Swap the found minimum element with the first element
            array[i] = array[min];
            array[min] = temp;
        }
    }

    private static void selectionSort2(int[] array) {
        for(int i = 0; i< array.length - 1; i++) {
            int min = i;
            int temp = array[i];
            for(int j = i + 1; j < array.length; j++) {
                if(array[j] < array[min]) {
                    min = j;
                }
            }
            array[i] = array[min];
            array[min] = temp;
        }
    }

    private static void selectionSort3(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            if (min != i) { // Avoid unnecessary swaps
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
    }
}
