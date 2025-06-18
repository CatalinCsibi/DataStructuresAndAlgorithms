package linkedlists;

public class DoublyLinkedList2 <V> {

    private Node first;
    private Node last;
    private int size;

    private class Node {

        private final V value;
        private Node next;
        private Node previous;

        public Node(V value) {
            this.value = value;
        }
    }

    public void addFirst(V value) {
        var node = new Node(value);
        if(isEmpty()){
            first = last = node;
        } else {
            first.previous = node;
            node.next = first;
            first = node;
        }
        size++;
    }

    public void addLast(V value) {
        var node = new Node(value);
        if(isEmpty()){
            first = last = node;
        } else {
            last.next = node;
            node.previous = last;
            last = node;
        }

        size++;
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

    public void remove(V value) {
        if(isEmpty())
            throw new IllegalStateException();

        if(first == last && first.value == value){
            first = last = null;
        } else if(last.value == value) {
            removeLast();
        } else {
            var current = first.next;
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
        size--;
    }

    public V getFirst() {
        if(isEmpty())
            throw new IllegalStateException();
        return first.value;
    }

    public V getLast() {
        if(isEmpty())
            throw new IllegalStateException();
        return last.value;
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

    public int size() {
        return size;
    }


    public boolean isEmpty() {
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
