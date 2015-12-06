package ro.sandorrobertk94.domain.adts;

import ro.sandorrobertk94.exceptions.domain.ArrayOverflowException;
import ro.sandorrobertk94.exceptions.domain.IndexOutOfBoundsException;

/**
 * Created by robert on 12/6/15.
 */
public class ArrayList implements IList<String> {
    private static final Integer CAPACITY = 100;
    private String[] array;
    private Integer size;

    public ArrayList() {
        array = new String[CAPACITY];
        size = 0;
    }

    @Override
    public void add(String element) throws ArrayOverflowException {
        if (size >= CAPACITY) {
            throw new ArrayOverflowException();
        }

        array[size] = element;
        size++;
    }

    @Override
    public String get(Integer index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        return array[index];
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public Integer size() {
        return size;
    }

    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < size; i++) {
            output += array[i] + "\n";
        }
        return output;
    }
}
