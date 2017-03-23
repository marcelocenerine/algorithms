package com.cenerino.algorithms.scala.math

import com.cenerino.algorithms.scala.math.SquareRoot._
import org.scalactic.TolerantNumerics
import org.scalatest.FunSuite

class SquareRootSuite extends FunSuite {

  implicit val doubleEquality = TolerantNumerics.tolerantDoubleEquality(0.0001)

  test("calculate square root") {
    assert(sqrt(81) === 9.0)
  }

  test("calculate square root of very small number") {
    assert(sqrt(1e-6) === 0.001)
  }

  test("calculate square root of very big number") {
    assert(sqrt(1e60) === 1.0000788456669446E30)
  }
}
