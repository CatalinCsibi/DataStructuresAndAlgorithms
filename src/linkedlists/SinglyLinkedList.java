package linkedlists;

import java.util.Stack;

public class SinglyLinkedList<E> {

    private Node first;
    private Node last;

    private int size;



    private class Node{

        private E value;

        private Node next;

        public Node(E value) {
            this.value = value;
        }
    }

    public void addFirst(E item) {
        var node = new Node(item);
        if(isEmpty()) {
            first = last = node;
        } else {
            node.next = first;
            first = node;
        }
        size++;
    }

    public void addLast(E item) {
        var node = new Node(item);
        if(isEmpty()) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public void deleteFirst() {
        if(isEmpty())
            throw new IllegalStateException();

        if(first == last)
            first = last = null;
        else
            first = first.next;

        size--;
    }

    public void deleteLast() {
        if(isEmpty())
            throw new IllegalStateException();

        if(first == last) {
            first = last = null;
        }
        else {
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

    public boolean contains(E item) {
        var node = first;
        while (node != null) {
            if(node.value == item)
                return true;

            node = node.next;
        }
        return false;
    }

    public int indexOf(E item) {
        var node = first;
        int index = 0;
        while (node != null) {
            if(node.value == item)
                return index;

            node = node.next;
            index++;
        }
        return -1;
    }

    public E get(int index) {
        if(index >= size)
            throw new IndexOutOfBoundsException();

        var node = first;
        while (true) {
            if(index == 0)
                return node.value;

            index--;
        }
    }

    public int size() {
        return size;
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

    public SinglyLinkedList<E> reverse() {
        Stack<E> stack = new Stack<>();
        var node = first;
            for (int i = 0; i < size; i++) {
                if(node != null) {
                    stack.add(node.value);
                }
                node = node.next;
        }
        SinglyLinkedList<E> singlyLinkedList = new SinglyLinkedList<>();
            while (!stack.isEmpty()) {
                singlyLinkedList.addLast(stack.pop());
            }
        return singlyLinkedList;
    }

    public void reverse2() {
        if(first.next == null) {
            return;
        }
        var head = this.first;
        var second = head.next;
        while (second != null) {
            var temp = second.next;
            second.next = head;
            head = second;
            second = temp;
        }
        this.first.next = null;
        this.first = head;

    }


}
