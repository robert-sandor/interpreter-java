package ro.sandorrobertk94.domain.adts;

import ro.sandorrobertk94.exceptions.domain.ArrayOverflowException;
import ro.sandorrobertk94.exceptions.domain.KeyNotFoundException;

import java.util.HashMap;

/**
 * Created by robert on 12/6/15.
 */
public class LibDictionary implements IDictionary<String, Integer> {
    private HashMap<String, Integer> map;

    public LibDictionary() {
        map = new HashMap<>();
    }

    @Override
    public void put(String key, Integer value) throws ArrayOverflowException {
        map.put(key, value);
    }

    @Override
    public Integer get(String key) throws KeyNotFoundException {
        Integer v = map.get(key);

        if (v == null) {
            throw new KeyNotFoundException();
        }

        return v;
    }

    @Override
    public Integer size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public String toString() {
        String output = "";
        for (String key : map.keySet()) {
            output += key + " => " + map.get(key).toString() + "\n";
        }
        return output;
    }
}
