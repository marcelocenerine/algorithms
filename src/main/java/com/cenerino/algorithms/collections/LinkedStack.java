package com.cenerino.algorithms.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedStack<T> implements Iterable<T> {

    private Node<T> first;

    public boolean isEmpty() {
        return first == null;
    }

    public void push(T value) {
        first = new Node<T>(value, first);
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        T value = first.value;
        first = first.next;
        return value;
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    private class StackIterator<T> implements Iterator {

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
