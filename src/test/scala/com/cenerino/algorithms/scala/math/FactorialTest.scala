package com.cenerino.algorithms.scala.math

import com.cenerino.algorithms.scala.math.Factorial._
import org.scalatest.FunSuite

class FactorialTest extends FunSuite {

  test("calculate factorial") {
    factorial(10) === 3628800
  }
}
