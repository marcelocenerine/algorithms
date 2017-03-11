package com.cenerino.algorithms.scala.math

import org.hamcrest.CoreMatchers._
import org.junit.Assert._
import org.scalatest.FunSuite

class GcdTest extends FunSuite {

  test("calculate greatest common divisor of positive numbers") {
    assertThat(Gcd.gcd(21, 14), is(7))
  }

  test("calculate greatest common divisor when one arg is zero") {
    assertThat(Gcd.gcd(1, 0), is(1))
  }

  test("calculate greatest common divisor when one number is negative") {
    assertThat(Gcd.gcd(-9, 3), is(3))
  }

  test("calculate greatest common divisor when both numbers are negative") {
    assertThat(Gcd.gcd(-15, -10), is(-5))
  }
}
