package arrays;

import java.util.Stack;

public class MyArray2 {

    private int[] items;
    int count;

    public MyArray2() {
        this.items = new int[5];
    }

    public MyArray2(int capacity) {
        this.items = new int[capacity];
    }

    public void insert(int item) {
        if (isFull())
            resizeArray();

        items[count++] = item;
    }

    public void removeLast() {
        if (isEmpty())
            throw new IllegalStateException();

        count--;
    }

    public void removeFirst() {
        if (isEmpty())
            throw new IllegalStateException();

        for (int i = 0; i < count; i++) {
            items[i] = items[i + 1];
            if (i == count - 1) {
                count--;
                break;
            }
        }
    }

    public void removeAt(int index) {
        if (isEmpty() || index > count - 1)
            throw new IllegalStateException();

        for (int i = index; i < count - 1; i++) {
            items[i] = items[i + 1];
        }
        count--;
    }


    public int get(int index) {
        if (isEmpty() || index >= count)
            throw new IndexOutOfBoundsException();

        return items[index];
    }

    public int indexOf(int item) {
        for (int i = 0; i < count; i++) {
            if (items[i] == item)
                return i;
        }
        return -1;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int max() {
        if (isEmpty())
            throw new IllegalStateException();

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < count; i++) {
            if (max < items[i])
                max = items[i];
        }
        return max;
    }

    public int min() {
        if (isEmpty())
            throw new IllegalStateException();

        int max = Integer.MAX_VALUE;

        for (int i = 0; i < count; i++) {
            if (max > items[i])
                max = items[i];
        }
        return max;
    }

    public void reverseArray() {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < count; i++)
            stack.push(items[i]);


        for (int i = 0; i < count; i++)
            items[i] = stack.pop();
    }

    private void resizeArray() {
        int[] newItems = new int[items.length * 2];
        for (int i = 0; i < count; i++)
            newItems[i] = items[i];

        items = newItems;
    }

    private boolean isFull() {
        return count == items.length;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < count; i++) {
            if (i == count - 1)
                stringBuilder.append(items[i]).append("]");
            else
                stringBuilder.append(items[i]).append(", ");
        }
        return stringBuilder.toString();
    }
}
