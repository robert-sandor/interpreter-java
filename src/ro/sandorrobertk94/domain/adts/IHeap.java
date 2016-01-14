package ro.sandorrobertk94.domain.adts;

import ro.sandorrobertk94.exceptions.domain.ArrayOverflowException;
import ro.sandorrobertk94.exceptions.domain.IndexOutOfBoundsException;

import java.io.Serializable;

/**
 * Created by Robert on 12/14/2015.
 */
public interface IHeap<E> extends Serializable {
    void add(E element) throws ArrayOverflowException;

    void update(Integer index, E element) throws IndexOutOfBoundsException;

    E get(Integer index) throws IndexOutOfBoundsException;

    boolean isEmpty();

    Integer size();

    String toString();
}
