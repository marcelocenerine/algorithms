package com.cenerino.algorithms.java.collections;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LinkedQueueTest {

    @Test
    public void shouldBeEmpty() {
        LinkedQueue<String> queue = new LinkedQueue<String>();

        assertThat(queue.isEmpty(), is(true));
    }

    @Test
    public void shouldBeEmptyAfterAddingAndRemoving() {
        LinkedQueue<String> queue = new LinkedQueue<String>();
        queue.enqueue("x");
        queue.dequeue();

        assertThat(queue.isEmpty(), is(true));
    }

    @Test
    public void shouldNotBeEmpty() {
        LinkedQueue<String> queue = new LinkedQueue<String>();
        queue.enqueue("first");

        assertThat(queue.isEmpty(), is(false));
    }

    @Test
    public void shouldReturnElementsInCorrectOrder() {
        LinkedQueue<String> queue = new LinkedQueue<String>();

        for (int x = 0; x < 30; x++) {
            queue.enqueue(String.valueOf(x));
        }

        for (int x = 0; x < 30; x++) {
            assertThat(queue.dequeue(), is(String.valueOf(x)));
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldFailIfPopIsCalledOnEmptyList() {
        LinkedQueue<String> queue = new LinkedQueue<String>();

        queue.dequeue();
    }

    @Test
    public void shouldIterateThroughItems() {
        LinkedQueue<String> queue = new LinkedQueue<String>();

        for (int x = 0; x < 30; x++) {
            queue.enqueue(String.valueOf(x));
        }

        Iterator<String> it = queue.iterator();
        int count = 0;

        while (it.hasNext()) {
            assertThat(it.next(), is(String.valueOf(count++)));
        }

        assertThat(count, is(30));
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldFailIfNextIsCalledOnIteratorWithNoMoreElements() {
        LinkedQueue<String> queue = new LinkedQueue<String>();
        queue.iterator().next();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shouldFailIfRemoveIsCalledOnIterator() {
        LinkedQueue<String> queue = new LinkedQueue<String>();
        queue.iterator().remove();
    }
}
