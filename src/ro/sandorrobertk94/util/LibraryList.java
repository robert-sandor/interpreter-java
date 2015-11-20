package ro.sandorrobertk94.util;

import ro.sandorrobertk94.exceptions.util.IndexOutOfBoundsException;

import java.util.LinkedList;

/**
 * Created by robert on 11/20/15.
 */
public class LibraryList implements IList<String> {
    private LinkedList<String> list;

    public LibraryList() {
        this.list = new LinkedList<>();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public void append(String element) {
        this.list.push(element);
    }

    @Override
    public String get(Integer position) throws IndexOutOfBoundsException {
        try {
            return this.list.get(position);
        } catch (java.lang.IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException(e);
        }
    }

    @Override
    public Integer getSize() {
        return this.list.size();
    }

    @Override
    public String toString() {
        String output = "";
        for (String s : list) {
            output += s + "\n";
        }
        return output;
    }
}
