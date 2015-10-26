package com.cenerino.algorithms.java.collections;

import java.util.NoSuchElementException;

public class PriorityQueue<T extends Comparable<T>> {

    private int n;
    private T[] heap;

    /**
     * TODO use resizeable array instead of informing capacity
     *
     * @param capacity
     */
    public PriorityQueue(int capacity) {
        this.heap = (T[]) new Comparable[capacity + 1];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void insert(T key) {
        heap[++n] = key;
        swim(n);
    }

    public T delMax() {
        if (isEmpty()) throw new NoSuchElementException();

        T max = heap[1];
        exchange(1, n--);
        sink(1);
        heap[n + 1] = null; // prevent loitering
        return max;
    }

    private void swim(int k) {
        // parent of k is @ k/2
        while (k > 1 && isLess(k / 2, k)) {
            exchange(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        // children of node k are 2k and 2k+1
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && isLess(j, j + 1)) j++;
            if (!isLess(k, j)) break;
            exchange(k, j);
            k = j;
        }
    }

    private boolean isLess(int i, int j) {
        return heap[i].compareTo(heap[j]) < 0;
    }

    private void exchange(int i, int j) {
        T aux = heap[i];
        heap[i] = heap[j];
        heap[j] = aux;
    }
}
