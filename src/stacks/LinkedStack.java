package stacks;

import java.util.LinkedList;

public class LinkedStack <T> {
    private LinkedList<T> stack;

    public LinkedStack() {
        stack = new LinkedList<T>();
    }

    public void push(T t) {
        stack.push(t);
    }

    public T pop() {
        return stack.pop();
    }

    public T peek() {
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void printStack() {
        for (T t : stack) {
            System.out.println(t);
        }
    }
}
