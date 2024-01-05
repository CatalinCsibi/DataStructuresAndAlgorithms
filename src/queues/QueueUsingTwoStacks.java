package queues;

import java.util.Stack;

public class QueueUsingTwoStacks <E> {

    private Stack<E> stack1 = new Stack<>();
    private Stack<E> stack2 = new Stack<>();

    public void enqueue(E item) {
        stack1.push(item);
    }

    public E dequeue() {
        if(isEmpty())
            throw new IllegalStateException();

        if(stack2.isEmpty())
            moveStack1ToStack2();

        return stack2.pop();
    }

    private void moveStack1ToStack2() {
        while (!stack1.isEmpty())
            stack2.push(stack1.pop());
    }

    public boolean isEmpty(){
        return stack1.isEmpty() && stack2.isEmpty();
    }

}
