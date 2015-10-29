package com.cenerino.algorithms.scala.math

import scala.annotation.tailrec

object Gcd {

  @tailrec
  def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
}
