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

    public void reverseLinkedList() {
        if (isEmpty())
            throw new IllegalStateException();

        var current = first;
        while (current != null) {
            var temp = current.next;
            current.next = current.previous;   // Swap next and previous
            current.previous = temp;           // Swap previous and next
            current = temp;                    // Move to the next node (which was the original next)
        }

        // Swap first and last pointers
        var temp = first;
        first = last;
        last = temp;
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

    public static void main(String[] args) {

        DoublyLinkedList2<String> doublyLinkedList2 = new DoublyLinkedList2<>();

        doublyLinkedList2.addFirst("Hello");
        doublyLinkedList2.addFirst("Salut");
        doublyLinkedList2.addLast("Bye");
        doublyLinkedList2.addLast("Ciao");

        System.out.println(doublyLinkedList2.size());
        System.out.println(doublyLinkedList2.contains("Ciao"));
        System.out.println(doublyLinkedList2.getFirst());
        System.out.println(doublyLinkedList2.getLast());

        doublyLinkedList2.removeFirst();
        doublyLinkedList2.removeLast();

        doublyLinkedList2.remove("Bye");

        doublyLinkedList2.addFirst("Salut");

        doublyLinkedList2.printLinkedList();

        doublyLinkedList2.reverseLinkedList();

        doublyLinkedList2.printLinkedList();
    }


}
