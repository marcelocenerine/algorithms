package com.cenerino.algorithms.scala.math

object Factorial {

  def factorial(n: Int): Int =
    if (n == 0) 1 else n * factorial(n - 1)
}
