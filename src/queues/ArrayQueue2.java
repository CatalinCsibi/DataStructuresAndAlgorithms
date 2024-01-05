package queues;

import java.util.Arrays;

public class ArrayQueue2 <E> {

    private Object[] items = new Object[5];

    private int first;
    private int last;

    private int count;

    public void enqueue(E item) {
        if(isFull())
            throw new IllegalStateException();

        items[last] = item;
        last = (last + 1) % items.length;
        count++;
    }

    public Object dequeue() {
        if(isEmpty())
            throw new IllegalStateException();

        var item = items[first];
        items[first] = null;
        first = (first + 1) % items.length;
        count--;

        return item;
    }

    private boolean isFull() {
        return count == items.length;
    }

    private boolean isEmpty() {
        return count == 0;
    }


    @Override
    public String toString(){
        return Arrays.toString(items);
    }
}
