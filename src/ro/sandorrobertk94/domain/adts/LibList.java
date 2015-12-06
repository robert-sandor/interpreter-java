package ro.sandorrobertk94.domain.adts;

import ro.sandorrobertk94.exceptions.domain.ArrayOverflowException;
import ro.sandorrobertk94.exceptions.domain.IndexOutOfBoundsException;

/**
 * Created by robert on 12/6/15.
 */
public class LibList<E> implements IList<E> {
    private java.util.ArrayList<E> list;

    public LibList() {
        list = new java.util.ArrayList<>();
    }

    @Override
    public void add(E element) throws ArrayOverflowException {
        list.add(element);
    }

    @Override
    public void update(Integer index, E element) throws IndexOutOfBoundsException {
        try {
            list.set(index, element);
        } catch (java.lang.IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public E get(Integer index) throws IndexOutOfBoundsException {
        try {
            return list.get(index);
        } catch (java.lang.IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public Integer size() {
        return list.size();
    }

    @Override
    public String toString() {
        String output = "";
        for (E line : list) {
            output += line.toString() + "\n";
        }
        return output;
    }
}
