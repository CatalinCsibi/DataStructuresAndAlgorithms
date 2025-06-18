package linkedlists;


import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

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
