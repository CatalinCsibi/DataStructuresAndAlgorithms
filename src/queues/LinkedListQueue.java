package queues;

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

    public void enqueue(V value) {
        var node = new Node(value);
        if(first == null) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public Object dequeue() {
        if(first == null)
            throw new IllegalStateException();

        var temp = first.value;
        if(first == last)
            first = last = null;
        else
            first = first.next;

        size--;
        return temp;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        var current = first;
        while (current != null) {
            stringBuilder.append(current.value).append(", ");
            current = current.next;

        }
        String itemsAsString = stringBuilder.toString();
        return itemsAsString.substring(0, itemsAsString.length() - 2) + "]";
    }


    public static void main(String[] args) {

        LinkedListQueue<String> linkedListQueue = new LinkedListQueue<>();

        linkedListQueue.enqueue("one");
        linkedListQueue.enqueue("two");
        linkedListQueue.enqueue("three");
        linkedListQueue.enqueue("four");
        linkedListQueue.enqueue("five");

        System.out.println(linkedListQueue.dequeue());
        System.out.println(linkedListQueue.dequeue());
        System.out.println(linkedListQueue.dequeue());
        System.out.println(linkedListQueue.dequeue());
        System.out.println(linkedListQueue.dequeue());
    }
}
