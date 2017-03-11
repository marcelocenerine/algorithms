package com.cenerino.algorithms.scala.math

import org.hamcrest.CoreMatchers._
import org.junit.Assert._
import org.scalatest.FunSuite

class FibonacciTest extends FunSuite {

  test("calculate 0th") {
    assertThat(Fibonacci.fib(0), is(0L))
    assertThat(Fibonacci.cachedFib(0), is(0L))
  }

  test("calculate 1st") {
    assertThat(Fibonacci.fib(1), is(1L))
    assertThat(Fibonacci.cachedFib(1), is(1L))
  }

  test("calculate 2nd") {
    assertThat(Fibonacci.fib(2), is(1L))
    assertThat(Fibonacci.cachedFib(2), is(1L))
  }

  test("calculate 3rd") {
    assertThat(Fibonacci.fib(3), is(2L))
    assertThat(Fibonacci.cachedFib(3), is(2L))
  }

  test("calculate 4th") {
    assertThat(Fibonacci.fib(4), is(3L))
    assertThat(Fibonacci.cachedFib(4), is(3L))
  }

  test("calculate 5th") {
    assertThat(Fibonacci.fib(5), is(5L))
    assertThat(Fibonacci.cachedFib(5), is(5L))
  }

  test("calculate 20th") {
    assertThat(Fibonacci.fib(20), is(6765L))
    assertThat(Fibonacci.cachedFib(20), is(6765L))
  }

  test("calculate 50th") {
    assertThat(Fibonacci.cachedFib(50), is(12586269025L))
  }
}
