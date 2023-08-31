class QueueUsingStacks {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public QueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Pushes an element into the queue.
    public void push(int item) {
        stack1.push(item);
    }

    // Pops an element from the queue.
    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    // Returns the front element of the queue without removing it.
    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    // Returns true if the queue is empty.
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
     public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("The top element is: " + stack.peek());

        stack.pop();

        System.out.println("The top element is: " + stack.peek());
    }
}
