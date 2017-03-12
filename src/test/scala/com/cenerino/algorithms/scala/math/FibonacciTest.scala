package com.cenerino.algorithms.scala.math

import com.cenerino.algorithms.scala.math.Fibonacci._
import org.scalatest.FunSuite

class FibonacciTest extends FunSuite {

  test("calculate 0th") {
    fib(0) === 0L
    cachedFib(0) === 0L
  }

  test("calculate 1st") {
    fib(1) === 1L
    cachedFib(1) === 1L
  }

  test("calculate 2nd") {
    fib(2) === 1L
    cachedFib(2) === 1L
  }

  test("calculate 3rd") {
    fib(3) === 2L
    cachedFib(3) === 2L
  }

  test("calculate 4th") {
    fib(4) === 3L
    cachedFib(4) === 3L
  }

  test("calculate 5th") {
    fib(5) === 5L
    cachedFib(5) === 5L
  }

  test("calculate 20th") {
    fib(20) === 6765L
    cachedFib(20) === 6765L
  }

  test("calculate 50th") {
    cachedFib(50) === 12586269025L
  }
}
