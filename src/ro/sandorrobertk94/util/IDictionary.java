package ro.sandorrobertk94.util;

import ro.sandorrobertk94.exceptions.util.ArrayOverflowException;
import ro.sandorrobertk94.exceptions.util.KeyNotFoundException;

import java.io.Serializable;

/**
 * Created by robert on 11/20/15.
 */
public interface IDictionary<K, V> extends Serializable {
    boolean isEmpty();
    void put(K key, V value) throws ArrayOverflowException;
    V get(K key) throws KeyNotFoundException;
    Integer getSize();
    String toString();
}
