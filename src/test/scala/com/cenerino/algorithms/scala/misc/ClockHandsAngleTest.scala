package com.cenerino.algorithms.scala.misc

import com.cenerino.algorithms.scala.misc.ClockHandsAngle._
import org.scalatest.FunSuite

class ClockHandsAngleTest extends FunSuite {

  test("calculate angle @ 00:00") {
    calcAngle(0, 0) === 0
  }

  test("calculate angle @ 00:30") {
    calcAngle(0, 30) === 180
  }

  test("calculate angle @ 03:45") {
    calcAngle(3, 45) === 180
  }

  test("calculate angle @ 12:45") {
    calcAngle(12, 45) === 270
  }

  test("calculate angle @ 15:00") {
    calcAngle(15, 0) === 90
  }

  test("calculate angle @ 23:55") {
    calcAngle(23, 55) === 0
  }

  test("calculate angle @ 23:59") {
    calcAngle(23, 59) === 24
  }

  test("calculate angle @ 12:59") {
    calcAngle(12, 59) === 354
  }
}
