package ro.sandorrobertk94.domain.adts;

import ro.sandorrobertk94.domain.statements.IStatement;
import ro.sandorrobertk94.exceptions.domain.ArrayOverflowException;
import ro.sandorrobertk94.exceptions.domain.EmptyStackException;

import java.util.Stack;

/**
 * Created by robert on 12/6/15.
 */
public class LibStack implements IStack<IStatement> {
    private Stack<IStatement> stack;

    public LibStack() {
        stack = new Stack<>();
    }

    @Override
    public void push(IStatement element) throws ArrayOverflowException {
        stack.push(element);
    }

    @Override
    public IStatement pop() throws EmptyStackException {
        try {
            return stack.pop();
        } catch (java.util.EmptyStackException e) {
            throw new EmptyStackException();
        }
    }

    @Override
    public IStatement top() throws EmptyStackException {
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
        for (IStatement statement : stack) {
            output += statement.toString() + "\n";
        }
        return output;
    }
}
