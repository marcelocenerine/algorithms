package com.cenerino.algorithms.scala.math

import org.hamcrest.CoreMatchers._
import org.junit.Assert._
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class FactorialTest extends FunSuite {

 test("calculate factorial") {
  assertThat(Factorial.factorial(10), is(3628800))
 }
}
