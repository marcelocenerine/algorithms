package com.cenerino.algorithms.java.misc;

public class ClockHandsAngle {

    /**
     * Given a time, calculate the angle between the hour and minute hands
     *
     * @param hours   - 0 - 23
     * @param minutes - 0 - 59
     * @return
     */
    public static int calcAngle(int hours, int minutes) {
        int hoursAngleRelTo12 = 360 / 12 * (hours % 12);
        int minutesAngleRelTo12 = 360 / 60 * minutes;

        return Math.abs(hoursAngleRelTo12 - minutesAngleRelTo12);
    }
}
