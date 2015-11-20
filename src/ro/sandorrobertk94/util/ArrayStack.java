package ro.sandorrobertk94.util;

import ro.sandorrobertk94.domain.statements.IStatement;
import ro.sandorrobertk94.exceptions.util.ArrayOverflowException;
import ro.sandorrobertk94.exceptions.util.EmptyStackException;

/**
 * Basic stack implementation on a fixed size array
 */
public class ArrayStack implements IStack<IStatement> {
    private final static Integer CAPACITY = 1024;
    private Integer size;
    private IStatement[] statementArray;

    public ArrayStack() {
        this.size = 0;
        this.statementArray = new IStatement[CAPACITY];
    }

    @Override
    public boolean isEmpty() {
        return (this.size == 0);
    }

    @Override
    public IStatement pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            IStatement statement = statementArray[size-1];
            statementArray[size-1] = null;
            size--;
            return statement;
        }
    }

    @Override
    public void push(IStatement element) throws ArrayOverflowException {
        if (size >= CAPACITY) {
            throw new ArrayOverflowException();
        }
        statementArray[size] = element;
        size++;
    }

    @Override
    public String toString() {
        String output = "";
        for (IStatement statement : statementArray) {
            output += statement.toString() + "\n";
        }
        return output;
    }
}
