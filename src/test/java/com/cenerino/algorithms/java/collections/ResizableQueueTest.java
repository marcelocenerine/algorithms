package com.cenerino.algorithms.java.collections;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ResizableQueueTest {

    @Test
    public void shouldBeEmpty() {
        ResizableQueue<String> queue = new ResizableQueue<String>();

        assertThat(queue.isEmpty(), is(true));
    }

    @Test
    public void shouldBeEmptyAfterAddingAndRemoving() {
        ResizableQueue<String> queue = new ResizableQueue<String>();
        queue.enqueue("x");
        queue.dequeue();

        assertThat(queue.isEmpty(), is(true));
    }

    @Test
    public void shouldNotBeEmpty() {
        ResizableQueue<String> queue = new ResizableQueue<String>();
        queue.enqueue("first");

        assertThat(queue.isEmpty(), is(false));
    }

    @Test
    public void shouldReturnElementsInCorrectOrder() {
        ResizableQueue<String> queue = new ResizableQueue<String>();

        for (int x = 0; x < 30; x++) {
            queue.enqueue(String.valueOf(x));
        }

        for (int x = 0; x < 25; x++) {
            assertThat(queue.dequeue(), is(String.valueOf(x)));
        }

        for (int x = 30; x < 100; x++) {
            queue.enqueue(String.valueOf(x));
        }

        for (int x = 25; x < 100; x++) {
            assertThat(queue.dequeue(), is(String.valueOf(x)));
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldFailIfQueueIsCalledOnEmptyList() {
        ResizableQueue<String> queue = new ResizableQueue<String>();

        queue.dequeue();
    }
}
