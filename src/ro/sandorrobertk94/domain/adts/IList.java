package ro.sandorrobertk94.domain.adts;

import ro.sandorrobertk94.exceptions.domain.ArrayOverflowException;
import ro.sandorrobertk94.exceptions.domain.IndexOutOfBoundsException;

import java.io.Serializable;

/**
 * Created by robert on 12/6/15.
 */
public interface IList<E> extends Serializable {
    void add(E element) throws ArrayOverflowException;
    E get(Integer index) throws IndexOutOfBoundsException;
    boolean isEmpty();
    Integer size();
    String toString();
}
