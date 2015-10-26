package com.cenerino.algorithms.java.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue<T> implements Iterable<T> {

    private Node<T> first, last;

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(T value) {
        Node<T> oldLast = last;
        last = new Node<>();
        last.value = value;

        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        T value = first.value;
        first = first.next;

        if (isEmpty()) {
            last = null;
        }

        return value;
    }

    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
    }

    private class Node<T> {
        private T value;
        private Node<T> next;
    }

    private class QueueIterator<T> implements Iterator {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            T value = (T) current.value;
            current = current.next;
            return value;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
