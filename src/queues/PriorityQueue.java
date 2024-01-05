package queues;

import java.util.Arrays;

public class PriorityQueue {

    private int[] items = new int[5];

    private int first;

    int count;

    public void add(int item) {
        if(isFull()) {
            int[] newItems = new int[items.length * 2];
            System.arraycopy(items, 0, newItems, 0, count);
            items = newItems;
        }
        var i = shiftItemsToInsert(item);
        items[i] = item;
        count++;
    }

    public int remove() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }

        return items[--count];
    }

    public int removeFromTheLowestInteger() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }

        int item = items[first++];
        count--;

        return item;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    private boolean isFull() {
        return count == items.length;
    }

    private int shiftItemsToInsert(int item) {
        int i;
        for(i = count - 1; i >= 0; i--){
            if(items[i] > item){
                items[i+1] = items[i];
            } else {
                break;
            }
        }
        return i+1;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}

