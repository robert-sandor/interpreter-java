package ro.sandorrobertk94.util;

import ro.sandorrobertk94.domain.statements.IStatement;
import ro.sandorrobertk94.exceptions.util.EmptyStackException;

import java.util.Stack;

/**
 * Created by robert on 11/20/15.
 */
public class LibraryStack implements IStack<IStatement> {
    private Stack<IStatement> stack;

    public LibraryStack() {
        this.stack = new Stack<>();
    }

    @Override
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    @Override
    public IStatement pop() throws EmptyStackException {
        try {
            return this.stack.pop();
        }
        catch (java.util.EmptyStackException e) {
            throw new EmptyStackException(e);
        }
    }

    @Override
    public void push(IStatement element) {
        this.stack.push(element);
    }

    @Override
    public String toString() {
        String output = "";
        for (IStatement st : stack) {
            output += st.toString() + "\n";
        }
        return output;
    }
}
