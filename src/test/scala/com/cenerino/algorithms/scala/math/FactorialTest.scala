package com.cenerino.algorithms.scala.math

import org.hamcrest.CoreMatchers._
import org.junit.Assert._
import org.scalatest.FunSuite

class FactorialTest extends FunSuite {

  test("calculate factorial") {
    assertThat(Factorial.factorial(10), is(3628800))
  }
}
