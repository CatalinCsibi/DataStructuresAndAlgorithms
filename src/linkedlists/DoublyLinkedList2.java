package linkedlists;

public class DoublyLinkedList2 <V> {

    private Node first;
    private Node last;


    private class Node {

        private V value;
        private Node next;
        private Node previous;

        public Node(V value) {
            this.value = value;
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
        if(first == last) {
            first = last = null;
            return;
        }

        first.next.previous = null;
        first = first.next;
    }

    public void removeLast() {
        if(first == last) {
            first = last = null;
            return;
        }

        last.previous.next = null;
        last = last.previous;
    }

    public void remove(V value) {
        if(first == last && first != null && first.value == value) {
            first = last = null;
            return;
        }
        var current = first;

        while (current != null) {
            if(current.value == value) {
                var next = current.next;
                var previous = current.previous;

                next.previous = previous;
                previous.next = next;
                break;
            }
            current = current.next;
        }
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
