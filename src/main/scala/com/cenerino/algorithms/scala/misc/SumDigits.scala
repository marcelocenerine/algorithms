package com.cenerino.algorithms.scala.misc

import scala.annotation.tailrec
import scala.math.abs

/**
 * Sum digits of an integer without converting it to String and splitting the characters.
 */
object SumDigits {

  def calc(num: Int) = {
    @tailrec
    def calc(num: Int, acc: Int): Int = {
      if (num == 0) acc
      else calc(num /10, acc + (num % 10))
    }

    calc(abs(num), 0)
  }
}
