import java.util.*;

public class NQueues {

    /**
     * The array to store the elements of the queues.
     */
    private int[] array;

    /**
     * The front pointers of the queues.
     */
    private int[] front;

    /**
     * The rear pointers of the queues.
     */
    private int[] rear;

    /**
     * The boundary of the array.
     */
    private int[] boundary;

    /**
     * The number of queues.
     */
    private int n;

    /**
     * Constructs a new NQueues object with the given capacity.
     *
     * @param n The capacity of the queues.
     */
    public NQueues(int n) {
        this.array = new int[n];
        this.front = new int[n];
        this.rear = new int[n];
        this.boundary = new int[n];
        for (int i = 0; i < n; i++) {
            front[i] = -1;
            rear[i] = -1;
            boundary[i] = i;
        }
        this.n = n;
    }

    /**
     * Checks if the given queue is empty.
     *
     * @param queue The index of the queue.
     * @return True if the queue is empty, false otherwise.
     */
    public boolean isEmpty(int queue) {
        return front[queue] == -1;
    }

    /**
     * Checks if the given queue is full.
     *
     * @param queue The index of the queue.
     * @return True if the queue is full, false otherwise.
     */
    public boolean isFull(int queue) {
        return rear[queue] == boundary[queue];
    }

    /**
     * Enqueues an element to the given queue.
     *
     * @param queue The index of the queue.
     * @param value The element to be enqueued.
     */
    public void enqueue(int queue, int value) {
        if (isFull(queue)) {
            throw new IllegalStateException("Queue is full");
        }

        rear[queue]++;
        array[rear[queue]] = value;
    }

    /**
     * Dequeues an element from the given queue.
     *
     * @param queue The index of the queue.
     * @return The element that was dequeued.
     */
    public int dequeue(int queue) {
        if (isEmpty(queue)) {
            throw new IllegalStateException("Queue is empty");
        }

        int value = array[front[queue]];
        front[queue]++;
        return value;
    }

    /**
     * Prints the elements of the queues.
     */
    public void print() {
        for (int i = 0; i < n; i++) {
            System.out.println("Queue " + i + ":");
            if (!isEmpty(i)) {
                System.out.print("[");
                for (int j = front[i]; j <= rear[i]; j++) {
                    System.out.print(array[j] + " ");
                }
                System.out.print("]");
            } else {
                System.out.println("Empty");
            }
        }
    }

    /**
     * The main method.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        NQueues queues = new NQueues(3);

        queues.enqueue(0, 1);
        queues.enqueue(1, 2);
        queues.enqueue(2, 3);

        queues.print();

        System.out.println("Dequeue from queue 0: " + queues.dequeue(0));

        queues.print();

        System.out.println("Dequeue from queue 1: " + queues.dequeue(1));

        queues.print();
    }
}
