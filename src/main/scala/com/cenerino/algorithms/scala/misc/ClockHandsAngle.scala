package com.cenerino.algorithms.scala.misc

import scala.math.abs

object ClockHandsAngle {

  /**
   * Given a time, calculate the angle between the hour and minute hands
   *
   * @param hours   - 0 - 23
   * @param minutes - 0 - 59
   * @return
   */
  def calcAngle(hours: Int, minutes: Int): Int = {
    val hoursAngleRelTo12 = 360 / 12 * (hours % 12)
    val minutesAngleRelTo12 = 360 / 60 * minutes
    return abs(hoursAngleRelTo12 - minutesAngleRelTo12)
  }
}
