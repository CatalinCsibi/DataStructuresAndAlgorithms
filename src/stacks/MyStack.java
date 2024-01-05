package stacks;

import arrays.Array;

import java.util.EmptyStackException;

public class MyStack {

    private int[] stack = new int[5];
    int index = 0;

    public void push(int item) {
        if(index == stack.length) {
            int [] newStack = new int[stack.length * 2];
            for(int i = 0; i < index; i++) {
                newStack[i] = stack[i];
            }
            stack = newStack;
        }
        stack[index++] = item;
    }

    public int pop() {
        if(isEmpty())
            throw new EmptyStackException();
        return stack[--index];
    }

    public int peek() {
        if(isEmpty())
            throw new EmptyStackException();
        return stack[index-1];
    }

    public void print() {
        if(index != 0) {
            for(int i = 0; i < index; i++) {
                System.out.print(stack[i] + " ");
            }
        }
        System.out.println();
    }

    public int max() {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < index; i++) {
            if(stack[i] > max) {
                max = stack[i];
            }
        }
        return max;
    }

    public int min() {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < index; i++) {
            if(stack[i] < min) {
                min = stack[i];
            }
        }
        return min;
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public int size(){
        return index;
    }
}
