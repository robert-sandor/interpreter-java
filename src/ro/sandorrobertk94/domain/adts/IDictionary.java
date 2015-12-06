package ro.sandorrobertk94.domain.adts;

import ro.sandorrobertk94.exceptions.domain.ArrayOverflowException;
import ro.sandorrobertk94.exceptions.domain.KeyNotFoundException;

import java.io.Serializable;

/**
 * Created by robert on 12/6/15.
 */
public interface IDictionary<K, V> extends Serializable {
    void put(K key, V value) throws ArrayOverflowException;
    V get(K key) throws KeyNotFoundException;
    Integer size();
    boolean isEmpty();
    String toString();
}
