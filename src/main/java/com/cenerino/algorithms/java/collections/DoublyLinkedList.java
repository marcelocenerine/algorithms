package com.cenerino.algorithms.java.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<T> implements Iterable<T> {

    private Node<T> first;
    private Node<T> last;
    private int size;

    public void addFirst(T value) {
        first = new Node(value, first, null);

        if (isEmpty()) {
            last = first;
        } else {
            first.next.prev = first;
        }

        size++;
    }

    public void addLast(T value) {
        last = new Node(value, null, last);

        if (isEmpty()) {
            first = last;
        } else {
            last.prev.next = last;
        }

        size++;
    }

    public T getFirst() {
        validateEmptiness();
        return first.value;
    }

    public T getLast() {
        validateEmptiness();
        return last.value;
    }

    public T get(int n) {
        return getNode(n).value;
    }

    private Node<T> getNode(int n) {
        validateIndex(n);
        int middle = (size - 1) / 2;
        return n <= middle ? stepForwards(n) : stepBackwards(n);
    }

    private Node<T> stepForwards(int n) {
        int currentPos = 0;
        Node<T> current = first;

        while (currentPos < n) {
            current = current.next;
            currentPos++;
        }

        return current;
    }

    private Node<T> stepBackwards(int n) {
        int currentPos = size - 1;
        Node<T> current = last;

        while (currentPos > n) {
            current = current.prev;
            currentPos--;
        }

        return current;
    }

    public T removeFirst() {
        validateEmptiness();
        return remove(0);
    }

    public T removeLast() {
        validateEmptiness();
        return remove(size - 1);
    }

    public boolean remove(T value) {
        Node<T> previous = null;
        Node<T> current = first;

        while (current != null) {
            if (current.value.equals(value)) {
                remove(current);
                return true;
            }

            previous = current;
            current = current.next;
        }

        return false;
    }

    public T remove(int n) {
        Node<T> node = getNode(n);
        remove(node);
        return node.value;
    }

    private void remove(Node<T> node) {
        if (node.prev == null) { // first
            first = node.next;
        } else {
            node.prev.next = node.next;
        }

        if (node.next == null) { // last
            last = node.prev;
        } else {
            node.next.prev = node.prev;
        }

        size--;
    }

    private void validateIndex(int n) {
        if (n < 0 || n >= size) throw new IndexOutOfBoundsException();
    }

    private void validateEmptiness() {
        if (isEmpty()) throw new NoSuchElementException();
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

    public Iterator<T> reverseIterator() {
        return new Iterator<T>() {

            private Node<T> current = last;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();

                T value = current.value;
                current = current.prev;
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
        private Node<T> prev;

        public Node(T value, Node<T> next, Node<T> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
