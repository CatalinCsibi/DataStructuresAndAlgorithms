package stacks;

public class LinkedListStack <V> {

    private Node first;
    private Node last;
    private int size;

    private class Node {

        private V value;
        private Node previous;

        public Node(V value) {
            this.value = value;
        }
    }

    public void push(V value) {
        var node = new Node(value);
        if(first == null) {
            first = last = node;
        } else {
            node.previous = last;
            last = node;
        }
        size++;
    }

    public V pop() {
        if(isEmpty())
            throw new IllegalStateException();

        V item = last.value;
        last = last.previous;
        size--;
        return item;

    }

    public V peek() {
        if(isEmpty())
            throw new IllegalStateException("Stack is empty, can't peek last item");

        return last.value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        var current = last;
        while (current != null) {
            stringBuilder.append(current.value).append(", ");
            current = current.previous;

        }
        String itemsAsString = stringBuilder.toString();
        return itemsAsString.substring(0, itemsAsString.length() - 2) + "]";
    }

    public static void main(String[] args) {

        LinkedListStack<String> linkedListStack = new LinkedListStack<>();

        linkedListStack.push("first");
        linkedListStack.push("second");
        linkedListStack.push("third");
        linkedListStack.push("fourth");
        linkedListStack.push("fifth");
        linkedListStack.push("sixth");
        linkedListStack.push("seventh");



        System.out.println(linkedListStack.peek());
        System.out.println(linkedListStack.pop());
        System.out.println(linkedListStack.pop());
        System.out.println(linkedListStack.pop());
        System.out.println(linkedListStack.pop());
        System.out.println(linkedListStack.pop());
        System.out.println(linkedListStack.isEmpty());

        System.out.println(linkedListStack);

    }


}
