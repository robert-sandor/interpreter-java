package ro.sandorrobertk94.domain.adts;

import ro.sandorrobertk94.exceptions.domain.ArrayOverflowException;
import ro.sandorrobertk94.exceptions.domain.EmptyStackException;

import java.util.Stack;

/**
 * Created by robert on 12/6/15.
 */
public class LibStack<E> implements IStack<E> {
    private Stack<E> stack;

    public LibStack() {
        stack = new Stack<>();
    }

    @Override
    public void push(E element) throws ArrayOverflowException {
        stack.push(element);
    }

    @Override
    public E pop() throws EmptyStackException {
        try {
            return stack.pop();
        } catch (java.util.EmptyStackException e) {
            throw new EmptyStackException();
        }
    }

    @Override
    public E top() throws EmptyStackException {
        try {
            return stack.peek();
        } catch (java.util.EmptyStackException e) {
            throw new EmptyStackException();
        }
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public String toString() {
        String output = "";
        for (E statement : stack) {
            output += statement.toString() + "\n";
        }
        return output;
    }
}
