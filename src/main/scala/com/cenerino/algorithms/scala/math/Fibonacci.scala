package com.cenerino.algorithms.scala.math

object Fibonacci {

  def fib(n: Int): Long =
    if (n == 0) 0
    else if (n == 1) 1
    else fib(n -1) + fib(n - 2)

  def cachedFib(n: Int): Long = {
    def cachedFib(n: Int, cache: Array[Long]): Long =
      if (n == 0) 0
      else if (n == 1) 1
      else {
        if (cache(n - 1) == 0) cache(n - 1) = cachedFib(n - 1, cache)
        if (cache(n - 2) == 0) cache(n - 2) = cachedFib(n - 2, cache)

        cache(n - 1) + cache(n - 2)
      }

    cachedFib(n, Array(n))
  }
}
