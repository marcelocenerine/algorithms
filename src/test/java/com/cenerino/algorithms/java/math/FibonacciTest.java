package com.cenerino.algorithms.java.math;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FibonacciTest {

    @Test
    public void shouldCalculate0th() {
        assertThat(Fibonacci.fib(0), is(0L));
        assertThat(Fibonacci.cachedFib(0), is(0L));
    }

    @Test
    public void shouldCalculate1st() {
        assertThat(Fibonacci.fib(1), is(1L));
        assertThat(Fibonacci.cachedFib(1), is(1L));
    }

    @Test
    public void shouldCalculate2nd() {
        assertThat(Fibonacci.fib(2), is(1L));
        assertThat(Fibonacci.cachedFib(2), is(1L));
    }

    @Test
    public void shouldCalculate3rd() {
        assertThat(Fibonacci.fib(3), is(2L));
        assertThat(Fibonacci.cachedFib(3), is(2L));
    }

    @Test
    public void shouldCalculate4th() {
        assertThat(Fibonacci.fib(4), is(3L));
        assertThat(Fibonacci.cachedFib(4), is(3L));
    }

    @Test
    public void shouldCalculate5th() {
        assertThat(Fibonacci.fib(5), is(5L));
        assertThat(Fibonacci.cachedFib(5), is(5L));
    }

    @Test
    public void shouldCalculate20th() {
        assertThat(Fibonacci.fib(20), is(6765L));
        assertThat(Fibonacci.cachedFib(20), is(6765L));
    }

    @Test
    public void shouldCalculate50th() {
        // assertThat(Fibonacci.fib(20), is(6765L)); takes too long
        assertThat(Fibonacci.cachedFib(50), is(12586269025L));
    }
}
