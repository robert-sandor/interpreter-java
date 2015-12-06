package ro.sandorrobertk94.domain.adts;

import ro.sandorrobertk94.exceptions.domain.ArrayOverflowException;
import ro.sandorrobertk94.exceptions.domain.KeyNotFoundException;

import java.util.HashMap;

/**
 * Created by robert on 12/6/15.
 */
public class LibDictionary<K, V> implements IDictionary<K, V> {
    private HashMap<K, V> map;

    public LibDictionary() {
        map = new HashMap<>();
    }

    @Override
    public void put(K key, V value) throws ArrayOverflowException {
        map.put(key, value);
    }

    @Override
    public V get(K key) throws KeyNotFoundException {
        V v = map.get(key);

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
        for (K key : map.keySet()) {
            output += key.toString() + " => " + map.get(key).toString() + "\n";
        }
        return output;
    }
}
