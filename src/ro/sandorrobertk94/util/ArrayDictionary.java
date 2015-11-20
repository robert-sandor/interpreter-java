package ro.sandorrobertk94.util;

import ro.sandorrobertk94.exceptions.util.ArrayOverflowException;
import ro.sandorrobertk94.exceptions.util.KeyNotFoundException;

import java.util.Objects;

/**
 * Created by robert on 11/20/15.
 */
public class ArrayDictionary implements IDictionary<String, Integer> {
    private final static Integer CAPACITY = 1024;
    private Integer size;
    private String[] keys;
    private Integer[] values;

    public ArrayDictionary() {
        this.size = 0;
        this.keys = new String[CAPACITY];
        this.values = new Integer[CAPACITY];
    }

    @Override
    public boolean isEmpty() {
        return (this.size == 0);
    }

    @Override
    public void put(String key, Integer value) throws ArrayOverflowException {
        if (this.size >= CAPACITY) {
            throw new ArrayOverflowException();
        }
        this.keys[size] = key;
        this.values[size] = value;
        this.size++;
    }

    @Override
    public Integer get(String key) throws KeyNotFoundException {
        String foundKey = null;
        int index;
        for (index = 0; index < this.size; index++) {
            if (Objects.equals(keys[index], key)) {
                foundKey = keys[index];
                break;
            }
        }

        if (foundKey == null) {
            throw new KeyNotFoundException();
        }

        return values[index];
    }

    @Override
    public Integer getSize() {
        return this.size;
    }

    @Override
    public String toString() {
        String output = "";
        for (int index = 0; index < size; index++) {
            output += keys[index] + " -> " + values[index].toString() + "\n";
        }
        return output;
    }
}
