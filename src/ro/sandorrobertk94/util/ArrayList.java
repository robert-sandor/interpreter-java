package ro.sandorrobertk94.util;

import ro.sandorrobertk94.exceptions.util.ArrayOverflowException;
import ro.sandorrobertk94.exceptions.util.IndexOutOfBoundsException;

/**
 * Created by robert on 11/20/15.
 */
public class ArrayList implements IList<String> {
    private static final Integer CAPACITY = 1024;
    private Integer size;
    private String[] stringArray;

    public ArrayList() {
        this.size = 0;
        this.stringArray = new String[CAPACITY];
    }

    @Override
    public boolean isEmpty() {
        return (this.size == 0);
    }

    @Override
    public void append(String element) throws ArrayOverflowException {
        if (this.size >= CAPACITY) {
            throw new ArrayOverflowException();
        }
        this.stringArray[this.size] = element;
        this.size++;
    }

    @Override
    public String get(Integer position) throws IndexOutOfBoundsException {
        if (position >= size || position < 0) {
            throw new IndexOutOfBoundsException();
        }
        return this.stringArray[position];
    }

    @Override
    public Integer getSize() {
        return this.size;
    }

    @Override
    public String toString() {
        String output = "";
        for (String s : stringArray) {
            output += s + "\n";
        }
        return output;
    }
}
