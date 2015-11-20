package ro.sandorrobertk94.util;

import ro.sandorrobertk94.exceptions.util.KeyNotFoundException;

import java.util.HashMap;

/**
 * Created by robert on 11/20/15.
 */
public class LibraryDictionary implements IDictionary<String, Integer> {
    private HashMap<String, Integer> dictionary;

    public LibraryDictionary() {
        this.dictionary = new HashMap<>();
    }

    @Override
    public boolean isEmpty() {
        return this.dictionary.isEmpty();
    }

    @Override
    public void put(String key, Integer value) {
        this.dictionary.put(key, value);
    }

    @Override
    public Integer get(String key) throws KeyNotFoundException {
        Integer value = this.dictionary.get(key);
        if (value == null) {
            throw new KeyNotFoundException();
        }
        return value;
    }

    @Override
    public Integer getSize() {
        return this.dictionary.size();
    }

    @Override
    public String toString() {
        String output = "";
        for (String key : this.dictionary.keySet()) {
            output += key + " -> " + this.dictionary.get(key).toString() + "\n";
        }
        return output;
    }
}
