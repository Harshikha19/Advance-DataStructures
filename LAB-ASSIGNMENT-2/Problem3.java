import java.util.*;

public class NQueues {

    
    // The array to store the elements of the queues. 
    private int[] array;
    //The front pointers of the queues
    private int[] front;
    // The rear pointers of the queues.
    private int[] rear;
    //The boundary of the array.
    private int[] boundary;
    //The number of queues.
    private int n;

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

    public boolean isEmpty(int queue) {
        return front[queue] == -1;
    }

    public boolean isFull(int queue) {
        return rear[queue] == boundary[queue];
    }

   
    public void enqueue(int queue, int value) {
        if (isFull(queue)) {
            throw new IllegalStateException("Queue is full");
        }

        rear[queue]++;
        array[rear[queue]] = value;
    }

  
    public int dequeue(int queue) {
        if (isEmpty(queue)) {
            throw new IllegalStateException("Queue is empty");
        }

        int value = array[front[queue]];
        front[queue]++;
        return value;
    }

    //Prints the elements of the queues.
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
