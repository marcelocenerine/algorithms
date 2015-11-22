package com.cenerino.algorithms.java.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList<T> implements Iterable<T> {

    private Node<T> first;
    private Node<T> last;
    private int size;

    public void addFirst(T value) {
        first = new Node(value, first);

        if (isEmpty()) last = first;

        size++;
    }

    public void addLast(T value) {
        Node<T> node = new Node(value, null);

        if (isEmpty()) {
            first = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }

        size++;
    }

    public T get(int n) {
        validateIndex(n);

        int currentPos = 0;
        Node<T> current = first;

        while (currentPos < n) {
            current = current.next;
            currentPos++;
        }

        return current.value;
    }

    private void validateIndex(int n) {
        if (n < 0 || n >= size) throw new IndexOutOfBoundsException();
    }

    private void validateEmptiness() {
        if (isEmpty()) throw new NoSuchElementException();
    }

    public T getFirst() {
        validateEmptiness();
        return first.value;
    }

    public T getLast() {
        validateEmptiness();
        return last.value;
    }

    public boolean remove(T value) {
        Node<T> previous = null;
        Node<T> current = first;

        while (current != null) {
            if (current.value.equals(value)) {
                remove(current, previous);
                return true;
            }

            previous = current;
            current = current.next;
        }

        return false;
    }

    public T remove(int n) {
        validateIndex(n);
        Node<T> previous = null;
        Node<T> current = first;
        int currentPos = 0;

        while (currentPos < n) {
            previous = current;
            current = current.next;
            currentPos++;
        }

        remove(current, previous);
        return current.value;
    }

    private void remove(Node<T> node, Node<T> previous) {
        if (previous == null) { // first
            first = node.next;
        } else {
            previous.next = node.next;
        }

        if (node.next == null) { // last
            last = previous;
        }

        size--;
    }

    public T removeFirst() {
        validateEmptiness();
        return remove(0);
    }

    public T removeLast() {
        validateEmptiness();
        return remove(size - 1);
    }

    /**
     * Method with side effect
     */
    public SinglyLinkedList<T> reverse() {
        if (size > 1) {
            Node<T> previous = null;
            Node<T> current = first;
            first = last;
            last = current;

            while (current != null) {
                Node<T> next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }
        }

        return this;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private Node<T> current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();

                T value = current.value;
                current = current.next;
                return value;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    private static class Node<T> {

        private T value;
        private Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
