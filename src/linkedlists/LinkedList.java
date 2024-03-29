package linkedlists;

import java.util.NoSuchElementException;

public class LinkedList {

    private class Node {

        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;

    private int size;


    public void addLast(int item) {
        var node = new Node(item);

        if(isEmpty()) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public void addFirst(int item) {
        var node = new Node(item);

        if(isEmpty()) {
            first = last = node;
        } else {
            node.next = first;
            first = node;
        }
        size++;
    }

    public int indexOf(int item) {
        int index = 0;
        var current = first;

        while (current != null) {
            if(current.value == item) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    public void removeFirst() {
        if(isEmpty())
            throw new NoSuchElementException();
        if(first == last) {
            first = last = null;
            size--;
            return;
        }
        var second = first.next;
        first.next = null;
        first = second;

        size--;
    }

    public void removeLast() {
        if(isEmpty())
            throw new NoSuchElementException();

        if(first == last) {
            first = last = null;
            size--;
            return;
        }

        var previous = getPrevious(last);
        last = previous;
        last.next = null;

        size--;
    }

    public int size() {
        return size;
    }

    public int[] toArray(){
        int[] array = new int[size];
        var current = first;
        var index = 0;

        while (current != null) {
            array[index++] = current.value;
            current = current.next;
        }
        return array;
    }

    public void reverse() {
        if (isEmpty()) {
            return;
        }

        var previous = first;
        var current = first.next;

        while(current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = previous;
    }

    public int getKthFromTheEnd(int k) {
        var a = first;
        var b = first;
        for(int i = 0; i < k-1; i++) {
            b = b.next;
            if(b == null)
                throw new IllegalArgumentException();
        }
        while (b != last) {
            a = a.next;
            b = b.next;
        }
        return a.value;
    }

    // My solution
    public int findKthNodeFromTheEnd(int k) {
        if(first == null || k > size || k < 1)
            return -1;
        else if (first == last && k == 1)
            return first.value;
        else {
            int i = 0;
            var node = first;

            while (i != (size - k)) {
                node = node.next;
                i++;
            }
            return node.value;
        }
    }

    public void printMiddle() {
        var a = first;
        var b = first;
        while (b != last && b.next != last) {
            b = b.next.next; a = a.next;
        }

        if (b == last)
            System.out.println(a.value);
        else
            System.out.println(a.value + ", "  + a.next.value);
    }

    // My solution
    public void getMiddle() {
        if(isEmpty() || first == last || first.next == last) {
            System.out.println("List with no middle");
            return;
        }

        int reminder = size % 2;
        int halfSize = size / 2;
        var node = first;

        if(reminder == 0) {
            int i = 0;
            while (i != halfSize - 1) {
                node = node.next;
                i++;
            }
            System.out.println("Midle numbers: " + node.value + ", " + node.next.value);
        } else {
            int i = 0;
            while (i != halfSize) {
                node = node.next;
                i++;
            }
            System.out.println("Midle number: " + node.value);
        }
    }

    private Node getPrevious(Node node) {
        var current = first;
        while (current != null)  {
            if (current.next == node) return current;
            current = current.next;
        }
        return null;
    }


    private boolean isEmpty() {
        return first == null;
    }
}
