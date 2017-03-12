package com.cenerino.algorithms.scala.misc

import com.cenerino.algorithms.scala.misc.SumDigits._
import org.scalatest.FunSuite

class SumDigitsSuite extends FunSuite {

  test("sum digits of zero") {
    calc(0) === 0
  }

  test("sum digits of single digit number") {
    calc(9) === 9
  }

  test("sum digits of two digits number") {
    calc(79) === 16
  }

  test("sum digits of long number") {
    calc(1234567890) === 45
  }

  test("sum digits of negative number") {
    calc(-987) === 24
  }
}
