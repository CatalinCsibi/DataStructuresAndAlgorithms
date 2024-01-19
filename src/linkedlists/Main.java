package linkedlists;


import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

//        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
//
//        singlyLinkedList.addFirst("third");
//        singlyLinkedList.addFirst("second");
//        singlyLinkedList.addFirst("first");
//        singlyLinkedList.addLast("fourth");
//        singlyLinkedList.addLast("last");
//
//        System.out.println(singlyLinkedList.size());
//
//        singlyLinkedList.deleteFirst();
//        singlyLinkedList.deleteLast();
//
//        System.out.println(singlyLinkedList.contains("first"));
//        System.out.println(singlyLinkedList.indexOf("third"));
//        System.out.println(singlyLinkedList.contains("last"));
//
//        System.out.println(singlyLinkedList.get(0));
//
//        System.out.println();

        DoublyLinkedList2<String> doublyLinkedList2 = new DoublyLinkedList2<>();

        doublyLinkedList2.addFirst("Hello");
        doublyLinkedList2.addFirst("Salut");
        doublyLinkedList2.addLast("Bye");
        doublyLinkedList2.addLast("Ciao");

        System.out.println(doublyLinkedList2.contains("Ciao"));

        doublyLinkedList2.removeFirst();
        doublyLinkedList2.removeFirst();
        doublyLinkedList2.removeLast();

        doublyLinkedList2.printLinkedList();


    }
}
