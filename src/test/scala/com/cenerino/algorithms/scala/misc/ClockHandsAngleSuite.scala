package com.cenerino.algorithms.scala.misc

import com.cenerino.algorithms.scala.misc.ClockHandsAngle._
import org.scalatest.FunSuite

class ClockHandsAngleSuite extends FunSuite {

  test("calculate angle @ 00:00") {
    assert(calcAngle(0, 0) === 0)
  }

  test("calculate angle @ 00:30") {
    assert(calcAngle(0, 30) === 180)
  }

  test("calculate angle @ 03:45") {
    assert(calcAngle(3, 45) === 180)
  }

  test("calculate angle @ 12:45") {
    assert(calcAngle(12, 45) === 270)
  }

  test("calculate angle @ 15:00") {
    assert(calcAngle(15, 0) === 90)
  }

  test("calculate angle @ 23:55") {
    assert(calcAngle(23, 55) === 0)
  }

  test("calculate angle @ 23:59") {
    assert(calcAngle(23, 59) === 24)
  }

  test("calculate angle @ 12:59") {
    assert(calcAngle(12, 59) === 354)
  }
}
