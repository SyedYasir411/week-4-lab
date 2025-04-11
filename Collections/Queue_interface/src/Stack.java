import java.util.*;

class StackUsingQueues {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    // Constructor
    public StackUsingQueues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    // Push an element onto the stack
    public void push(int x) {
        queue1.offer(x);
    }

    // Pop the top element of the stack
    public int pop() {
        // Move all but the last element to queue2
        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }
        // The last element in queue1 is the top of the stack
        int top = queue1.poll();
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return top;
    }

    // Get the top element of the stack
    public int top() {
        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }
        int top = queue1.peek();
        queue2.offer(queue1.poll());

        // Swap the queues again
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return top;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return queue1.isEmpty();
    }
}

public class Stack {
    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();

        // Push elements onto the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Pop and get the top element
        System.out.println("Pop: " + stack.pop()); // Should print 3
        System.out.println("Top: " + stack.top()); // Should print 2
    }
}
