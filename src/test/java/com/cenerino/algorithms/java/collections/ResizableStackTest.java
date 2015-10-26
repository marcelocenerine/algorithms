package com.cenerino.algorithms.java.collections;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ResizableStackTest {

    @Test
    public void shouldBeEmpty() {
        ResizableStack<String> stack = new ResizableStack<String>();

        assertThat(stack.isEmpty(), is(true));
    }

    @Test
    public void shouldBeEmptyAfterAddingAndRemoving() {
        ResizableStack<String> stack = new ResizableStack<String>();
        stack.push("x");
        stack.pop();

        assertThat(stack.isEmpty(), is(true));
    }

    @Test
    public void shouldNotBeEmpty() {
        ResizableStack<String> stack = new ResizableStack<String>();
        stack.push("first");

        assertThat(stack.isEmpty(), is(false));
    }

    @Test
    public void shouldReturnElementsInCorrectOrder() {
        ResizableStack<String> stack = new ResizableStack<String>();

        for (int x = 1; x <= 30; x++) {
            stack.push(String.valueOf(x));
        }

        for (int x = 30; x >= 1; x--) {
            assertThat(stack.pop(), is(String.valueOf(x)));
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldFailIfPopIsCalledOnEmptyList() {
        ResizableStack<String> stack = new ResizableStack<String>();

        stack.pop();
    }
}
