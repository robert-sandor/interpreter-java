package ro.sandorrobertk94.util;

import ro.sandorrobertk94.exceptions.util.ArrayOverflowException;
import ro.sandorrobertk94.exceptions.util.IndexOutOfBoundsException;

import java.io.Serializable;

/**
 * Created by robert on 11/20/15.
 */
public interface IList<T> extends Serializable {
    boolean isEmpty();
    void append(T element) throws ArrayOverflowException;
    T get(Integer position) throws IndexOutOfBoundsException;
    Integer getSize();
    String toString();
}
