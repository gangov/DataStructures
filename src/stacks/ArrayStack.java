package stacks;

import java.lang.reflect.Array;
import java.util.EmptyStackException;

public class ArrayStack <T> {
    private T[] stack;
    private int top;

    public ArrayStack(int capacity) {
        stack = (T[]) new Employee[capacity];
    }

    public void push(T t) {
        if (top == stack.length) {
            Employee[] newArray = new Employee[stack.length * 2];
            System.arraycopy(stack, 0, newArray, 0, stack.length);
            stack = (T[]) newArray;
        }

        stack[top++] = (T) t;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        T t = stack[--top];
        stack[top] = null;
        return t;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return stack[top - 1];
    }

    public int size() {
        return top;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public void printStack() {
        for (int i = top - 1; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }
}
