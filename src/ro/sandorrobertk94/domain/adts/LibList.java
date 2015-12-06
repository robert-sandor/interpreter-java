package ro.sandorrobertk94.domain.adts;

import ro.sandorrobertk94.exceptions.domain.ArrayOverflowException;
import ro.sandorrobertk94.exceptions.domain.IndexOutOfBoundsException;

/**
 * Created by robert on 12/6/15.
 */
public class LibList implements IList<String> {
    private java.util.ArrayList<String> list;

    public LibList() {
        list = new java.util.ArrayList<>();
    }

    @Override
    public void add(String element) throws ArrayOverflowException {
        list.add(element);
    }

    @Override
    public String get(Integer index) throws IndexOutOfBoundsException {
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
        for (String line : list) {
            output += line + "\n";
        }
        return output;
    }
}
