package com.cenerino.algorithms.java.collections;

import java.util.Iterator;
import java.util.LinkedList;

public class HashTable<K, V> {

    private static final int CAPACITY = 100;
    private Object[] table = new Object[CAPACITY]; // could be implemented using a resizable array + rehashing
    private int size;

    public V put(K key, V value) {
        LinkedList<Entry<K, V>> bucket = getOrCreateBucket(key);
        Entry<K, V> entry = findEntry(key, bucket);

        if (entry != null) {
            V oldValue = entry.value;
            entry.value = value;
            return oldValue;
        }

        bucket.add(new Entry<>(key, value));
        size++;
        return null;
    }

    public V get(K key) {
        Entry<K, V> entry = getEntry(key);
        return entry != null ? entry.value : null;
    }

    private Entry<K, V> getEntry(K key) {
        return findEntry(key, getBucket(key));
    }

    private Entry<K, V> findEntry(K key, LinkedList<Entry<K, V>> bucket) {
        if (bucket == null) return null;

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry;
            }
        }

        return null;
    }

    private LinkedList<Entry<K, V>> getOrCreateBucket(K key) {
        LinkedList<Entry<K, V>> bucket = getBucket(key);

        if (bucket == null) {
            bucket = new LinkedList<>();
            table[hash(key)] = bucket;
        }

        return bucket;
    }

    private LinkedList<Entry<K, V>> getBucket(K key) {
        return (LinkedList<Entry<K, V>>) table[hash(key)];
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % CAPACITY; // the code masks off the sign bit (to turn the 32-bit integer into a 31-bit non-negative integer)
    }

    public boolean containsKey(K key) {
        return getEntry(key) != null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean remove(K key) {
        LinkedList<Entry<K, V>> bucket = getBucket(key);

        if (bucket == null) return false;

        Iterator<Entry<K, V>> iterator = bucket.iterator();

        while (iterator.hasNext()) {
            Entry<K, V> entry = iterator.next();

            if (key.equals(entry.key)) {
                iterator.remove();
                size--;
                return true;
            }
        }

        return false;
    }

    private static class Entry<K, V> {

        private K key;
        private V value;

        private Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
