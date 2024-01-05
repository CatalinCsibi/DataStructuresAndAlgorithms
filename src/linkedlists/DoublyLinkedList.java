package linkedlists;

public class DoublyLinkedList {

    private Node first;
    private Node last;

    private int size;

    private class Node {

        private int value;
        private Node previous;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public void addLast(int value) {
        var node = new Node(value);
        if (isEmpty()) {
            first = last = node;
        } else {
            node.previous = last;
            last.next = node;
            last = node;
        }

        size++;
    }

    public void addFirst(int value) {
        var node = new Node(value);
        if (isEmpty()) {
            first = last = node;
        } else {
            first.previous = node;
            node.next = first;
            first = node;
        }

        size++;
    }

    public void removeLast() {
        if (isEmpty())
            throw new IllegalStateException();

        if (first == last) {
            first = last = null;
        } else {
            last = last.previous;
            last.next = null;
        }
        size--;
    }

    public void removeFirst() {
        if (isEmpty())
            throw new IllegalStateException();

        if (first == last) {
            first = last = null;
        } else {
            first = first.next;
            first.previous = null;
        }
        size--;
    }

    public boolean contains(int value) {
        if (!isEmpty()) {
            var node = first;
            while (node != null) {
                if (node.value == value)
                    return true;

                node = node.next;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    private boolean isEmpty() {
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

    public void getMiddle() {
        if(isEmpty())
            throw new IllegalStateException();

        int remainder = size % 2;
        int middle = size / 2;
        var node = first;

        if(remainder != 0) {
            for(int i = 0; i < middle + 1; i++){
                node = node.next;
            }
            System.out.println(node.value);
        } else {
            for(int i = 0; i < middle; i++){
                node = node.next;
            }
            System.out.println(node.previous.value + " " + node.value);
        }
    }
}
