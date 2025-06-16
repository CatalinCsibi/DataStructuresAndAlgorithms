package algorithms.sorting;


public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {5, 7, 3, 1, 10, 90, 65, 2};
        bubbleSort(array);

        for(int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
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



}
