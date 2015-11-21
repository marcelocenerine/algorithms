package com.cenerino.algorithms.scala.misc

import org.hamcrest.CoreMatchers._
import org.junit.Assert._
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ClockHandsAngleTest extends FunSuite {

  test("calculate angle @ 00:00") {
    assertThat(ClockHandsAngle.calcAngle(0, 0), is(0))
  }

  test("calculate angle @ 00:30") {
    assertThat(ClockHandsAngle.calcAngle(0, 30), is(180))
  }

  test("calculate angle @ 03:45") {
    assertThat(ClockHandsAngle.calcAngle(3, 45), is(180))
  }

  test("calculate angle @ 12:45") {
    assertThat(ClockHandsAngle.calcAngle(12, 45), is(270))
  }

  test("calculate angle @ 15:00") {
    assertThat(ClockHandsAngle.calcAngle(15, 0), is(90))
  }

  test("calculate angle @ 23:55") {
    assertThat(ClockHandsAngle.calcAngle(23, 55), is(0))
  }

  test("calculate angle @ 23:59") {
    assertThat(ClockHandsAngle.calcAngle(23, 59), is(24))
  }

  test("calculate angle @ 12:59") {
    assertThat(ClockHandsAngle.calcAngle(12, 59), is(354))
  }
}
