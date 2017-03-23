package com.cenerino.algorithms.scala.math

import com.cenerino.algorithms.scala.math.Fibonacci._
import org.scalatest.FunSuite

class FibonacciSuite extends FunSuite {

  test("calculate 0th") {
    assert(fib(0) === 0L)
    assert(cachedFib(0) === 0L)
  }

  test("calculate 1st") {
    assert(fib(1) === 1L)
    assert(cachedFib(1) === 1L)
  }

  test("calculate 2nd") {
    assert(fib(2) === 1L)
    assert(cachedFib(2) === 1L)
  }

  test("calculate 3rd") {
    assert(fib(3) === 2L)
    assert(cachedFib(3) === 2L)
  }

  test("calculate 4th") {
    assert(fib(4) === 3L)
    assert(cachedFib(4) === 3L)
  }

  test("calculate 5th") {
    assert(fib(5) === 5L)
    assert(cachedFib(5) === 5L)
  }

  test("calculate 20th") {
    assert(fib(20) === 6765L)
    assert(cachedFib(20) === 6765L)
  }

  test("calculate 50th") {
    assert(cachedFib(50) === 12586269025L)
  }
}
