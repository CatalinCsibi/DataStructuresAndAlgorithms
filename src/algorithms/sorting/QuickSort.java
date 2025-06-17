package algorithms.sorting;

/*
Example: Sort [8, 4, 5, 7, 1, 3, 6, 2]
1. Pick a Pivot:
Let's pick the last element as pivot = 2

Partition Step:
Move all elements smaller than 2 to the left: [1]   [4,5,7,8,3,6]   2 (pivot)
Now put pivot in the correct position:
[1,2]   [4,5,7,8,3,6]

2. Recursively sort left and right sides:
Left [1,2] is sorted.

Sort [4,5,7,8,3,6]:

Pick pivot = 6
[4,5,3]   [7,8]   6 (pivot)
Place pivot correctly:
[4,5,3,6]   [7,8]
Sort [4,5,3]:

Pivot = 3  -> []   [4,5]   3 (pivot)
Place pivot: [3,4,5]

No need to sort [7,8] (already sorted).

3. Combine All: [1,2] + [3,4,5] + [6] + [7,8] = [1,2,3,4,5,6,7,8]

Final Sorted Array: [1, 2, 3, 4, 5, 6, 7, 8]
Key Points:
        ✔ Partitioning: O(n) work per level
        ✔ Number of levels: O(log n) (if balanced)
        ✔ Total: O(n log n) average time

*/

public class QuickSort {

    public static void main(String[] args) {
        int[] numbers = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};

        quickSort(numbers, 0, numbers.length - 1);

        // Print sorted array
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }

    public static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pivot = right; // Choose rightmost element as pivot
            int partitionIndex = partition(array, pivot, left, right);

            // Recursively sort left and right parts
            quickSort(array, left, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, right);
        }
    }

    public static int partition(int[] array, int pivot, int left, int right) {
        int pivotValue = array[pivot];
        int partitionIndex = left;

        for (int i = left; i < right; i++) {
            if (array[i] < pivotValue) {
                swap(array, i, partitionIndex);
                partitionIndex++;
            }
        }
        swap(array, right, partitionIndex);
        return partitionIndex;
    }

    public static void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }
}

