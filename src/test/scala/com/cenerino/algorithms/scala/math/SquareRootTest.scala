package com.cenerino.algorithms.scala.math

import org.junit.Assert._
import org.scalatest.FunSuite

class SquareRootTest extends FunSuite {

  test("calculate square root") {
    val result = SquareRoot.sqrt(81);

    assertEquals(9.0, result, 0.0001)
  }

  test("calculate square root of very small number") {
    val result = SquareRoot.sqrt(1e-6);

    assertEquals(0.001, result, 0.0001)
  }

  test("calculate square root of very big number") {
    val result = SquareRoot.sqrt(1e60);

    assertEquals(1.0000788456669446E30, result, 0.0)
  }
}
