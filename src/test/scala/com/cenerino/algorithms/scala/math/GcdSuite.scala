package com.cenerino.algorithms.scala.math

import com.cenerino.algorithms.scala.math.Gcd._
import org.scalatest.FunSuite

class GcdSuite extends FunSuite {

  test("calculate greatest common divisor of positive numbers") {
    gcd(21, 14) === 7
  }

  test("calculate greatest common divisor when one arg is zero") {
    gcd(1, 0) === 1
  }

  test("calculate greatest common divisor when one number is negative") {
    gcd(-9, 3) === 3
  }

  test("calculate greatest common divisor when both numbers are negative") {
    gcd(-15, -10) === -5
  }
}
