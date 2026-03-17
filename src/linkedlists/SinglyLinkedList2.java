package linkedlists;

import java.util.Stack;

public class SinglyLinkedList2 <V>{

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

    public void addFirst(V value) {
        var node = new Node(value);
        if(isEmpty()) {
            first = last = node;
        } else {
            node.next = first;
            first = node;
        }
        size++;
    }

    public void addLast(V value) {
        var node = new Node(value);
        if(first == null)
            first = last = node;
        else {
            last.next = node;
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
        }
        size--;
    }

    public void removeLast() {
        if(isEmpty())
            throw new IllegalStateException();

        if(first == last) {
            first = last = null;
        } else {
            var node = first;
            while (true) {
                if(node.next == last) {
                    last = node;
                    node.next = null;
                    break;
                }
                node = node.next;
            }
        }
        size--;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        if (index == 0) {
            removeFirst();
            return;
        }

        Node current = first;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        Node nodeToRemove = current.next;
        current.next = nodeToRemove.next;

        if (nodeToRemove == last)
            last = current;

        size--;
    }

    public boolean contains(V value) {
        if(last != null && last.value == value)
            return true;

        var node = first;
        while (node != null) {
            if(node.value == value)
                return true;

            node = node.next;
        }
        return false;
    }

    public int indexOf(V value) {
        if(last != null && last.value == value)
            return size-1;

        int index = 0;
        var current = first;
        while (current != null) {
            if(current.value == value)
                return index;

            current = current.next;
            index++;
        }
        return -1;
    }

    public V get(int index) {
        if(index >= size)
            throw new IndexOutOfBoundsException();

        if(index == size-1) {
            return last.value;
        }
        var current = first;
        int count = 0;
        while (current != null) {
            if(count == index) {
                return current.value;
            }
            current=current.next;
            count++;
        }
        throw new IllegalStateException();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void reverseLinkedListUsingStack() {
        if(isEmpty())
            throw new IllegalStateException();

        Stack<V> stack = new Stack<>();
        var current = first;
        while (current != null) {
            stack.push(current.value);
            current= current.next;
        }
        current = first;
        while (current != null &&!stack.isEmpty()) {
            current.value = stack.pop();
            current= current.next;
        }
    }

    public void reverseLinkedList() {
        if(first == null || first.next == null)
            return;

        var head = first;
        var second = head.next;
        while (second != null) {
            var temp = second.next;
            second.next = head;
            head = second;
            second = temp;
        }
        this.first.next = null;
        this.last = first;
        this.first = head;
    }

    public void printLinkedList() {
        if(isEmpty())
            throw new IllegalStateException();

        var current = first;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SinglyLinkedList2<Integer> singlyLinkedList2 = new SinglyLinkedList2<>();

        singlyLinkedList2.addFirst(4);
        singlyLinkedList2.addFirst(5);
        singlyLinkedList2.addLast(6);
        singlyLinkedList2.addLast(8);
        singlyLinkedList2.addFirst(10);
        singlyLinkedList2.addLast(11);

        singlyLinkedList2.removeFirst();
        singlyLinkedList2.removeLast();
        singlyLinkedList2.removeLast();

        System.out.println(singlyLinkedList2.indexOf(4));
        System.out.println(singlyLinkedList2.get(1));

        singlyLinkedList2.addLast(7);

        singlyLinkedList2.printLinkedList();

        singlyLinkedList2.reverseLinkedList();
        singlyLinkedList2.removeLast();
        singlyLinkedList2.removeAt(1);

        singlyLinkedList2.printLinkedList();

    }
}
