package com.cenerino.algorithms.scala.math

import com.cenerino.algorithms.scala.math.SquareRoot._
import org.scalatest.FunSuite

class SquareRootTest extends FunSuite {

  test("calculate square root") {
    sqrt(81) === 9.0
  }

  test("calculate square root of very small number") {
    sqrt(1e-6) === 0.001
  }

  test("calculate square root of very big number") {
    sqrt(1e60) === 1.0000788456669446E30
  }
}
