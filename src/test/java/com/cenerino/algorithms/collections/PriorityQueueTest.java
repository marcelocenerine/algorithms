package com.cenerino.algorithms.collections;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
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

    public static void main(String[] args) {
        //94 88 71 80 33 12 15 37 61 10
        PriorityQueue<Integer> pq = new PriorityQueue<>(15);
//        pq.insert(94);
//        pq.insert(88);
//        pq.insert(71);
//        pq.insert(80);
//        pq.insert(33);
//        pq.insert(12);
//        pq.insert(15);
//        pq.insert(37);
//        pq.insert(61);
//        pq.insert(10);
//
//        pq.insert(87);
//        pq.insert(98);
//        pq.insert(52);

        //85 82 63 81 21 45 50 34 47 19
        pq.insert(85);
        pq.insert(82);
        pq.insert(63);
        pq.insert(81);
        pq.insert(21);
        pq.insert(45);
        pq.insert(50);
        pq.insert(34);
        pq.insert(47);
        pq.insert(19);

        pq.delMax();
        pq.delMax();
        pq.delMax();


        System.out.println(Arrays.toString(pq.heap));
    }
}
