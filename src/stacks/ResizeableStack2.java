package stacks;

import stacks.exceptions.StackIsEmptyException;

public class ResizeableStack2<V>{

    private Object[] items;
    private int size;

    public ResizeableStack2() {
        this.items = new Object[5];
    }

    public ResizeableStack2(int initialCapacity) {
        this.items = new Object[initialCapacity];
    }

    public void push(V value) {
        if(isFull())
            resize();
        items[size++] = value;
    }

    public Object pop() {
        if(isEmpty())
            throw new StackIsEmptyException();

        return items[--size];
    }

    public Object peek() {
        if(isEmpty())
            throw new StackIsEmptyException();

        return items[size -1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize() {
        Object[] newStack = new Object[items.length * 2];

        for(int i = 0; i<size; i++){
            newStack[i] = items[i];
        }
        items = newStack;
    }

    private boolean isFull() {
        return size == items.length;
    }

    public void printStack() {
        for(int i = 0; i<size; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        ResizeableStack2<String> resizeableStack2 = new ResizeableStack2<>(3);

        resizeableStack2.push("Hello");
        resizeableStack2.push("Bye");
        resizeableStack2.push("Goodbye");
        resizeableStack2.push("Ciao");
        resizeableStack2.push("Goodnight");

        System.out.println(resizeableStack2.peek());
        System.out.println(resizeableStack2.pop());
        System.out.println(resizeableStack2.pop());
        System.out.println(resizeableStack2.pop());

        resizeableStack2.printStack();

    }
}
