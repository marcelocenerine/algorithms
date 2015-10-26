package com.cenerino.algorithms.java.collections;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PriorityQueueTest {

    @Test
    public void shouldAddKeysAndReturnInPriorityOrder() {
        PriorityQueue<Integer> pq = new PriorityQueue<>(10);

        pq.insert(1);
        pq.insert(10);
        pq.insert(8);
        pq.insert(3);
        pq.insert(4);
        pq.insert(2);

        assertThat(pq.delMax(), is(10));
        assertThat(pq.delMax(), is(8));
        assertThat(pq.delMax(), is(4));

        pq.insert(7);
        pq.insert(5);
        pq.insert(9);
        pq.insert(6);
        pq.insert(4);
        pq.insert(10);
        pq.insert(8);

        for (int x = 10; x < 0; x++) {
            assertThat(pq.delMax(), is(x));
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldFailIfDelMaxIsInvokedOnEmptyQueue() {
        PriorityQueue<Integer> pq = new PriorityQueue<>(10);
        pq.insert(1);

        pq.delMax();
        pq.delMax();
    }
}
