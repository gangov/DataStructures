package queues;

import java.util.NoSuchElementException;
import java.util.Objects;

public class ArrayQueue <T> {
    private T[] queue;
    private int front;
    private int back;

    public ArrayQueue(int capacity) {
        queue = (T[]) new Object[capacity];
    }

    public void add(T t) {
        if (size() == queue.length - 1) {
            int numItems = size();
            T[] newArray = (T[]) new Object[2 * queue.length];

            System.arraycopy(queue, front, newArray, 0, queue.length - front);
            System.arraycopy(queue, 0, newArray, queue.length - front, back);

            queue = (T[]) newArray;

            front = 0;
            back = numItems;
        }


        queue[back] = (T) t;
        if (back < queue.length - 1) {
            back++;
        } else {
            back = 0;
        }
    }

    public T remove() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }

        T t = (T) queue[front];
        queue[front] = null;
        front++;

        if (size() == 0) {
            front = 0;
            back = 0;
        } else if (front == queue.length) {
            front = 0;
        }

        return t;
    }

    public T peek() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }

        return (T) queue[front];
    }

    public int size() {
        if (front <= back) {
            return back - front;
        } else {
            return back - front + queue.length;
        }
    }

    public void printQueue() {
        if (front <= back) {
            for (int i = front; i < back; i++) {
                System.out.println(queue[i]);
            }
        } else {
            for (int i = front; i < queue.length; i++) {
                System.out.println(queue[i]);
            }
            for (int i = 0; i < back; i++) {
                System.out.println(queue[i]);
            }
        }

    }
}
