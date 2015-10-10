package com.cenerino.algorithms.collections;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LinkedStackTest {

    @Test
    public void shouldBeEmpty() {
        LinkedStack<String> stack = new LinkedStack<String>();

        assertThat(stack.isEmpty(), is(true));
    }

    @Test
    public void shouldBeEmptyAfterAddingAndRemoving() {
        LinkedStack<String> stack = new LinkedStack<String>();
        stack.push("x");
        stack.pop();

        assertThat(stack.isEmpty(), is(true));
    }

    @Test
    public void shouldNotBeEmpty() {
        LinkedStack<String> stack = new LinkedStack<String>();
        stack.push("first");

        assertThat(stack.isEmpty(), is(false));
    }

    @Test
    public void shouldReturnElementsInCorrectOrder() {
        LinkedStack<String> stack = new LinkedStack<String>();

        for (int x = 1; x <= 30; x++) {
            stack.push(String.valueOf(x));
        }

        for (int x = 30; x >= 1; x--) {
            assertThat(stack.pop(), is(String.valueOf(x)));
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldFailIfPopIsCalledOnEmptyList() {
        LinkedStack<String> stack = new LinkedStack<String>();

        stack.pop();
    }

    @Test
    public void shouldIterateThroughItems() {
        LinkedStack<String> stack = new LinkedStack<String>();

        for (int x = 0; x < 30; x++) {
            stack.push(String.valueOf(x));
        }

        Iterator<String> it = stack.iterator();
        int count = 30;

        while (it.hasNext()) {
            assertThat(it.next(), is(String.valueOf(--count)));
        }

        assertThat(count, is(0));
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldFailIfNextIsCalledOnIteratorWithNoMoreElements() {
        new LinkedStack<String>().iterator().next();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shouldFailIfRemoveIsCalledOnIterator() {
        new LinkedStack<String>().iterator().remove();
    }
}
