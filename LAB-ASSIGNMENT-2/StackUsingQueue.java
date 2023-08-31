import java.util.Queue;

public class StackUsingQueue {

    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public StackUsingQueue() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    // Push an element into the stack.
    public void push(int data) {
        // Move all elements from q1 to q2.
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        // Push the given item into q1.
        q1.add(data);
    }

    // Pop an element from the stack.
    public int pop() {
        // Check if the stack is empty.
        if (q1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        // Move all elements from q1 to q2 except the last element.
        int data = q1.remove();
        while (q1.size() > 1) {
            q2.add(q1.remove());
        }

        // The last element in q1 is the top element of the stack.
        return data;
    }

    // Check if the stack is empty.
    public boolean isEmpty() {
        return q1.isEmpty();
    }
     public static void main(String[] args) {
        StackUsingQueue stack = new StackUsingQueue();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("The top element is: " + stack.peek());
        System.out.println("Popping the top element: " + stack.pop());
        System.out.println("The top element is: " + stack.peek());
    }
}
