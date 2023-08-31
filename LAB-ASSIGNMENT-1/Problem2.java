class Stack {
  // An array to store the elements of the stacks.
  int[] arr;

  // An array to store the top element of each stack.
  int[] top;

  // The number of stacks.
  int n;

  /**
   * Constructs a stack with the specified number of stacks.
   *
   * @param n The number of stacks.
   */
  public Stack(int n) {
    // Initialize the arrays.
    this.arr = new int[n];
    this.top = new int[n];

    // Initialize all stacks to be empty.
    for (int i = 0; i < n; i++) {
      this.top[i] = -1;
    }
  }

  /**
   * Pushes an element onto the specified stack.
   *
   * @param stackNum The number of the stack to push the element onto.
   * @param data The element to push.
   */
  public void push(int stackNum, int data) {
    // Check if the stack is full.
    if (isFull(stackNum)) {
      System.out.println("Stack is full");
      return;
    }

    // Find the next free index in the array.
    int nextFreeIndex = top[stackNum] + 1;
    if (nextFreeIndex == n) {
      nextFreeIndex = 0;
    }

    // Update the top array and store the element.
    top[stackNum] = nextFreeIndex;
    arr[nextFreeIndex] = data;
  }

  /**
   * Pops an element from the specified stack.
   *
   * @param stackNum The number of the stack to pop the element from.
   * @return The element popped.
   */
  public int pop(int stackNum) {
    // Check if the stack is empty.
    if (isEmpty(stackNum)) {
      System.out.println("Stack is empty");
      return -1;
    }

    // Get the top element from the array.
    int data = arr[top[stackNum]];

    // Update the top array.
    top[stackNum]--;

    return data;
  }

  /**
   * Checks if the specified stack is empty.
   *
   * @param stackNum The number of the stack to check.
   * @return True if the stack is empty, False otherwise.
   */
  public boolean isEmpty(int stackNum) {
    // The stack is empty if the top array element is equal to -1.
    return top[stackNum] == -1;
  }

  /**
   * Checks if the specified stack is full.
   *
   * @param stackNum The number of the stack to check.
   * @return True if the stack is full, False otherwise.
   */
  public boolean isFull(int stackNum) {
    // The stack is full if the top array element is equal to the array size minus 1.
    return top[stackNum] == n - 1;
  }
}

public class Main {
  public static void main(String[] args) {
    // Create a stack with 3 stacks.
    int n = 3;
    Stack stack = new Stack(n);

    // Push some elements onto the stacks.
    stack.push(0, 1);
    stack.push(0, 2);
    stack.push(1, 3);
    stack.push(2, 4);

    // Pop some elements off the stacks.
    System.out.println(stack.pop(0)); // 2
    System.out.println(stack.pop(1)); // 3
    System.out.println(stack.pop(2)); // 4
  }
}
