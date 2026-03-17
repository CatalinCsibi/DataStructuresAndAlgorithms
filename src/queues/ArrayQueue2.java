package queues;

import java.util.Arrays;

public class ArrayQueue2 <E> {

    private final Object[] items;
    private int first;
    private int last;

    public ArrayQueue2() {
        this.items = new Object[5];
    }

    public void enqueue(E item) {
        items[last] = item;
        last = (last + 1) % items.length;
    }

    public Object dequeue() {
        var item = items[first];
        items[first] = null;
        first = (first + 1) % items.length;
        return item;
    }


    @Override
    public String toString(){
        return Arrays.toString(items);
    }

    public static void main(String[] args) {

        ArrayQueue2<String> arrayQueue2 = new ArrayQueue2<>();

        arrayQueue2.enqueue("first");
        arrayQueue2.enqueue("second");
        arrayQueue2.enqueue("third");
        arrayQueue2.enqueue("fourth");
        arrayQueue2.enqueue("fifth");

        System.out.println(arrayQueue2.dequeue());
        System.out.println(arrayQueue2.dequeue());
        System.out.println(arrayQueue2.dequeue());
        System.out.println(arrayQueue2.dequeue());
        System.out.println(arrayQueue2.dequeue());

        arrayQueue2.enqueue("fifth");
        arrayQueue2.enqueue("fourth");

        System.out.println(arrayQueue2.dequeue());

        System.out.println(arrayQueue2);
        System.out.println(arrayQueue2.dequeue());

        System.out.println();
    }
}
