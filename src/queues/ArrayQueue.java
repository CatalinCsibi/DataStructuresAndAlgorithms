package queues;

import java.util.Arrays;

public class ArrayQueue {



    private int[] items = new int[5];

    private int rear;
    private int front;
    private int count;

    public ArrayQueue(int capacity) {
        items = new int[capacity];
    }

    public void myEnqueue(int item) {
        if(count == items.length)
            throw new IllegalStateException();

        if(rear == items.length)
            rear = 0;

        items[rear++] = item;
        count++;
    }

    public void enqueue(int item) {
        if(isFull())
            throw new IllegalStateException();

        items[rear] = item;
        rear = (rear + 1) % items.length;
        count++;
    }

    public int myDequeue(){
        if (front == items.length)
            front = 0;

        var item = items[front];

        items[front++] = 0;
        count--;
        return item;
    }


    public int dequeue(){
        var item = items[front];

        items[front] = 0;
        front = (front + 1) % items.length;
        count--;
        return item;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public boolean isFull(){
        return count == items.length;
    }

    @Override
    public String toString(){
        return Arrays.toString(items);
    }


}
