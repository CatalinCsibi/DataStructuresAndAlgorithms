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

    public void push(V value) {
        var node = new Node(value);
        if(first == null) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public V pop() {
        if(isEmpty())
            throw new IllegalStateException("Queue is empty, can't pop last item");

        V value = first.value;
        first = first.next;
        size--;

        return value;
    }

    public V peek() {
        if(isEmpty())
            throw new IllegalStateException("Queue is empty, can't peek last item");

        return first.value;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
