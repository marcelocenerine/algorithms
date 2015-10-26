package com.cenerino.algorithms.java.collections;

import java.util.NoSuchElementException;

public class ResizableQueue<T> {

    private static final int MIN_SIZE = 10;
    private Object[] items = new Object[MIN_SIZE];
    private int head = 0;
    private int tail = 0;


    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return tail - head;
    }

    private boolean shouldGrow() {
        return tail == items.length;
    }

    private boolean shouldShrink() {
        int quarter = items.length / 4;
        return size() == quarter && tail > MIN_SIZE;
    }

    public void enqueue(T value) {
        if (shouldGrow()) resize();

        items[tail++] = value;
    }

    private void resize() {
        Object[] copy = new Object[size() * 2];

        for (int x = 0; x < size(); x++) {
            copy[x] = items[x + head];
        }

        tail = tail - head;
        head = 0;
        items = copy;
    }

    public T dequeue() {
        if (isEmpty()) throw new NoSuchElementException();

        Object item = items[head];
        items[head++] = null;

        if (shouldShrink()) resize();

        return (T) item;
    }
}
