package queues;


import java.util.Queue;
import java.util.Stack;

public class Main {

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

        System.out.println();

        QueueUsingTwoStacks<String> queueUsingTwoStacks = new QueueUsingTwoStacks<>();

        queueUsingTwoStacks.enqueue("first");
        queueUsingTwoStacks.enqueue("second");
        queueUsingTwoStacks.enqueue("third");
        queueUsingTwoStacks.enqueue("fourth");
        queueUsingTwoStacks.enqueue("fifth");
        queueUsingTwoStacks.enqueue("sixth");
        queueUsingTwoStacks.enqueue("seventh");
        queueUsingTwoStacks.enqueue("eighth");
        queueUsingTwoStacks.enqueue("ninth");

        System.out.println(queueUsingTwoStacks.dequeue());
        System.out.println(queueUsingTwoStacks.dequeue());
        System.out.println(queueUsingTwoStacks.dequeue());
        System.out.println(queueUsingTwoStacks.dequeue());
        System.out.println(queueUsingTwoStacks.dequeue());
        System.out.println(queueUsingTwoStacks.dequeue());
        System.out.println(queueUsingTwoStacks.dequeue());
        System.out.println(queueUsingTwoStacks.dequeue());
        System.out.println(queueUsingTwoStacks.dequeue());





    }

    // My solution
    private static void reverseQueue(Queue<Integer> queue) {

    }

    private static void reverse(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();

        while (!queue.isEmpty())
            stack.push(queue.remove());
        while (!stack.isEmpty())
            queue.add(stack.pop());
    }
}
