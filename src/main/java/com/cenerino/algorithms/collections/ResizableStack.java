package com.cenerino.algorithms.collections;

import java.util.NoSuchElementException;

public class ResizableStack<T> {

    private static final int MIN_SIZE = 10;
    private Object[] items = new Object[MIN_SIZE];
    private int n = 0;


    public boolean isEmpty() {
        return n == 0;
    }

    private boolean shouldGrow() {
        return n == items.length;
    }

    private boolean shouldShrink() {
        int quarter = items.length / 4;
        return n == quarter && n > MIN_SIZE;
    }

    public void push(T value) {
        if (shouldGrow()) resize(items.length * 2);

        items[n++] = value;
    }

    private void resize(int capacity) {
        Object[] copy = new Object[capacity];

        for (int x = 0; x < n; x++) {
            copy[x] = items[x];
        }

        items = copy;
    }

    public T pop() {
        if (isEmpty()) throw new NoSuchElementException();

        Object item = items[--n];
        items[n] = null;

        if (shouldShrink()) resize(items.length / 2);

        return (T) item;
    }
}
