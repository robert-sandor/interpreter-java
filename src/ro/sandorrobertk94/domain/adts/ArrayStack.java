package ro.sandorrobertk94.domain.adts;

import ro.sandorrobertk94.domain.statements.IStatement;
import ro.sandorrobertk94.exceptions.domain.ArrayOverflowException;
import ro.sandorrobertk94.exceptions.domain.EmptyStackException;

/**
 * Created by robert on 12/6/15.
 */
public class ArrayStack implements IStack<IStatement> {
    private static final Integer CAPACITY = 100;
    private IStatement[] array;
    private Integer size;

    public ArrayStack() {
        array = new IStatement[CAPACITY];
        size = 0;
    }

    @Override
    public void push(IStatement element) throws ArrayOverflowException {
        if (size >= CAPACITY) {
            throw new ArrayOverflowException();
        }

        array[size] = element;
        size++;
    }

    @Override
    public IStatement pop() throws EmptyStackException {
        if (size <= 0) {
            throw new EmptyStackException();
        }

        size--;
        IStatement e = array[size];
        array[size] = null;
        return e;
    }

    @Override
    public IStatement top() throws EmptyStackException {
        if (size <= 0) {
            throw new EmptyStackException();
        }

        return array[size - 1];
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < size; i++) {
            output += array[i].toString() + "\n";
        }
        return output;
    }
}
