package stacks;

import java.util.EmptyStackException;

public class ResizeableStack <E> {


    private Object[] items;

    private int count;

    public ResizeableStack() {
        items = new Object[10];
    }

    public ResizeableStack(int initialCapacity) {
        this.items = new Object[initialCapacity];
    }

    public void push(E item) {
        if(isFull())
            resizeStack();

        items[count++] = item;
    }

    public Object pop() {
        if(isEmpty())
            throw new EmptyStackException();

        return items[--count];
    }

    public Object peek() {
        if(isEmpty())
            throw new EmptyStackException();

        return items[count - 1];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    private void resizeStack() {
        Object[] newStack = new Object[items.length * 2];
        for(int i = 0; i < count; i++)
            newStack[i] = items[i];

        items = newStack;

    }

    private boolean isFull() {
        return count == items.length;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < count; i++) {
            stringBuilder.append(items[i]).append(", ");
        }
        String itemsAsString = stringBuilder.toString();
        return itemsAsString.substring(0, itemsAsString.length() - 2) + "]";
    }
}
