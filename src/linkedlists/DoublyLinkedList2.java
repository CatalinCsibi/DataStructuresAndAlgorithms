package linkedlists;

public class DoublyLinkedList2 <V> {

    private Node first;
    private Node last;

    private class Node {

        private final V value;

        private Node previous;
        private Node next;

        public Node(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", previous=" + previous +
                    ", next=" + next +
                    '}';
        }
    }

    public void addFirst(V value) {
        var node = new Node(value);
        if(isEmpty()) {
            first = last = node;
            return;
        }

        first.previous = node;
        node.next = first;

        first = node;
    }

    public void addLast(V value) {
        var node = new Node(value);
        if(isEmpty()) {
            first = last = node;
            return;
        }

        last.next = node;
        node.previous = last;

        last = node;
    }

    public boolean contains(V value) {
        var current = first;

        while (current != null) {
            if(current.value == value)
                return true;

            current = current.next;
        }
        return false;
    }

    public void removeFirst() {
        if(isEmpty())
            throw new IllegalStateException();

        if(first == last) {
            first = last = null;
            return;
        }

        first = first.next;
        first.previous = null;
    }

    public void removeLast() {
        if(isEmpty())
            throw new IllegalStateException();

        if(first == last) {
            first = last = null;
            return;
        }

        last = last.previous;
        last.next = null;
    }

    private boolean isEmpty() {
        return first == null;
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
