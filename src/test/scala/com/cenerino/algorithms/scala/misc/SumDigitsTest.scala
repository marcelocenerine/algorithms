package com.cenerino.algorithms.scala.misc

import org.hamcrest.CoreMatchers._
import org.junit.Assert._
import org.scalatest.FunSuite

class SumDigitsTest extends FunSuite {

  test("sum digits of zero") {
    assertThat(SumDigits.calc(0), is(0))
  }

  test("sum digits of single digit number") {
    assertThat(SumDigits.calc(9), is(9))
  }

  test("sum digits of two digits number") {
    assertThat(SumDigits.calc(79), is(16))
  }

  test("sum digits of long number") {
    assertThat(SumDigits.calc(1234567890), is(45))
  }

  test("sum digits of negative number") {
    assertThat(SumDigits.calc(-987), is(24))
  }
}
