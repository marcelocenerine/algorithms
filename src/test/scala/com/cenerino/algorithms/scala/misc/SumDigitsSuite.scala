package com.cenerino.algorithms.scala.misc

import com.cenerino.algorithms.scala.misc.SumDigits._
import org.scalatest.FunSuite

class SumDigitsSuite extends FunSuite {

  test("sum digits of zero") {
    assert(calc(0) === 0)
  }

  test("sum digits of single digit number") {
    assert(calc(9) === 9)
  }

  test("sum digits of two digits number") {
    assert(calc(79) === 16)
  }

  test("sum digits of long number") {
    assert(calc(1234567890) === 45)
  }

  test("sum digits of negative number") {
    assert(calc(-987) === 24)
  }
}
