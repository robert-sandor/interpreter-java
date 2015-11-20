package ro.sandorrobertk94.util;

import ro.sandorrobertk94.exceptions.util.ArrayOverflowException;
import ro.sandorrobertk94.exceptions.util.EmptyStackException;

import java.io.Serializable;

/**
 * Basic Stack Interface
 * isEmpty() - checks whether the stack is empty
 * pop() - returns the top of the stack and deletes it
 * push() - adds an element to the top of the stack
 * toString() - returns a string representation of the stack
 */
public interface IStack<T> extends Serializable {
    boolean isEmpty();
    T pop() throws EmptyStackException;
    void push(T element) throws ArrayOverflowException;
    String toString();
}
