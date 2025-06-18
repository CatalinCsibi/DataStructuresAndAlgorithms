package queues;

import java.util.Stack;

public class QueueUsingTwoStacks <E> {

   private Stack<E> stack1 = new Stack<>();
   private Stack<E> stack2 = new Stack<>();

   public void enqueue(E item) {
       stack1.push(item);
   }

   public E dequeue() {
       moveStack1ToStack2();
       return stack2.pop();
   }

   public E peek() {
       moveStack1ToStack2();
       return stack2.peek();
   }

    private void moveStack1ToStack2() {
        if(stack2.isEmpty()) {
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
    }

    public static void main(String[] args) {
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


}
