package linkedlists;

public class DoublyLinkedList2 <T> {

    private Node first;
    private Node last;

    private int size;

    private class Node {
        private Node previous;
        private Node next;

        private T value;

        public Node(T value) {
            this.value = value;
        }
    }

    public void addLast(T item) {
        var node = new Node(item);
        if(first == null) {
            first = last = node;
        } else {
            node.previous = last;
            last.next = node;
            last = node;
        }
        size++;
    }

    public void addFirst(T item) {
        var node = new Node(item);
        if(first == null) {
            first = last = node;
        } else {
            node.next = first;
            first.previous = node;
            first = node;
        }
        size++;
    }

    public void removeLast() {
        if(isEmpty())
            throw new IllegalStateException();

        if(first == last) {
            first = last = null;
        } else {
            last = last.previous;
            last.next = null;
        }
        size--;
    }

    public void removeFirst() {
        if(isEmpty())
            throw new IllegalStateException();

        if(first == last) {
            first = last = null;
        } else {
            first = first.next;
            first.previous = null;
        }
        size--;
    }

    public boolean contains(T value) {
        var current = first;
        while (current != null) {
            if(current.value == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void printLinkedList() {
        if (isEmpty())
            throw new IllegalStateException();

        var node = first;
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }


}
