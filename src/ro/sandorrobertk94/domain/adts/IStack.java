package ro.sandorrobertk94.domain.adts;

import ro.sandorrobertk94.exceptions.domain.ArrayOverflowException;
import ro.sandorrobertk94.exceptions.domain.EmptyStackException;

import java.io.Serializable;

/**
 * Created by robert on 12/6/15.
 */
public interface IStack<E> extends Serializable {
    void push(E element) throws ArrayOverflowException;
    E pop() throws EmptyStackException;
    E top() throws EmptyStackException;
    boolean isEmpty();
    String toString();
}
