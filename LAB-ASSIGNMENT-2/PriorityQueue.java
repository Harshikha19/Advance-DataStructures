import java.util.*;

public class PriorityQueue {

    private int[][] array;
    private int size;

    public PriorityQueue(int capacity) {
        array = new int[capacity][2];
        size = 0;
    }

    public void add(int value, int priority) {
        int i;
        for (i = 0; i < size; i++) {
            if (array[i][1] < priority) {
                break;
            }
        }

        for (int j = size - 1; j >= i; j--) {
            array[j + 1][0] = array[j][0];
            array[j + 1][1] = array[j][1];
        }

        array[i][0] = value;
        array[i][1] = priority;
        size++;
    }

    public int remove() {
        if (size == 0) {
            throw new IllegalStateException("Priority queue is empty");
        }

        int value = array[0][0];
        int priority = array[0][1];

        for (int i = 1; i < size; i++) {
            array[i - 1][0] = array[i][0];
            array[i - 1][1] = array[i][1];
        }

        size--;
        return value;
    }

    public int peek() {
        if (size == 0) {
            throw new IllegalStateException("Priority queue is empty");
        }

        return array[0][0];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println("[" + array[i][0] + ", " + array[i][1] + "]");
        }
    }

    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue(10);

        queue.add(1, 1);
        queue.add(2, 2);
        queue.add(3, 3);
        queue.add(4, 4);
        queue.add(5, 5);

        queue.print();

        System.out.println("Remove: " + queue.remove());
        System.out.println("Remove: " + queue.remove());

        queue.print();
    }
}
