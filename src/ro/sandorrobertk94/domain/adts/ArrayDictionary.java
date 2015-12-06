package ro.sandorrobertk94.domain.adts;

import ro.sandorrobertk94.exceptions.domain.ArrayOverflowException;
import ro.sandorrobertk94.exceptions.domain.KeyNotFoundException;

import java.util.Objects;

/**
 * Created by robert on 12/6/15.
 */
public class ArrayDictionary implements IDictionary<String, Integer> {
    private static final Integer CAPACITY = 100;
    private String[] keys;
    private Integer[] values;
    private Integer size;

    public ArrayDictionary() {
        keys = new String[CAPACITY];
        values = new Integer[CAPACITY];
        size = 0;
    }

    @Override
    public void put(String key, Integer value) throws ArrayOverflowException {
        if (size >= CAPACITY) {
            throw new ArrayOverflowException();
        }

        Integer i = 0;
        while (i < size) {
            if (Objects.equals(keys[i], key)) {
                break;
            }
            i++;
        }

        keys[i] = key;
        values[i] = value;

        if (Objects.equals(i, size)) {
            size++;
        }
    }

    @Override
    public Integer get(String key) throws KeyNotFoundException {
        Integer i = 0;
        while (i < size) {
            if (Objects.equals(keys[i], key)) {
                break;
            }
            i++;
        }

        if (Objects.equals(i, size)) {
            throw new KeyNotFoundException();
        } else {
            return values[i];
        }
    }

    @Override
    public Integer size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < size; i++) {
            output += keys[i] + " => " + values[i].toString() + "\n";
        }
        return output;
    }
}
