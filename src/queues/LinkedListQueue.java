package queues;

import stacks.LinkedListStack;

public class LinkedListQueue <V>{

    private Node first;
    private Node last;
    private int size;

    private class Node {

        private V value;
        private Node next;

        public Node(V value) {
            this.value = value;
        }
    }

    public void enqueue(V value) {
        var node = new Node(value);
        if(first == null) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public V dequeue() {
        if(isEmpty())
            throw new IllegalStateException("Queue is empty, can't dequeue last item");

        V value = first.value;
        first = first.next;
        size--;

        return value;
    }


    public boolean isEmpty() {
        return size == 0;
    }
}
