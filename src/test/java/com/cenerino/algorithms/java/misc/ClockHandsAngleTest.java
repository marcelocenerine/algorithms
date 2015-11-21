package com.cenerino.algorithms.java.misc;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ClockHandsAngleTest {

    @Test
    public void shouldCalculateAngleAt00_00() {
        assertThat(ClockHandsAngle.calcAngle(0, 0), is(0));
    }

    @Test
    public void shouldCalculateAngleAt00_30() {
        assertThat(ClockHandsAngle.calcAngle(0, 30), is(180));
    }

    @Test
    public void shouldCalculateAngleAt03_45() {
        assertThat(ClockHandsAngle.calcAngle(3, 45), is(180));
    }

    @Test
    public void shouldCalculateAngleAt12_45() {
        assertThat(ClockHandsAngle.calcAngle(12, 45), is(270));
    }

    @Test
    public void shouldCalculateAngleAt15_00() {
        assertThat(ClockHandsAngle.calcAngle(15, 00), is(90));
    }

    @Test
    public void shouldCalculateAngleAt23_55() {
        assertThat(ClockHandsAngle.calcAngle(23, 55), is(0));
    }

    @Test
    public void shouldCalculateAngleAt23_59() {
        assertThat(ClockHandsAngle.calcAngle(23, 59), is(24));
    }

    @Test
    public void shouldCalculateAngleAt12_59() {
        assertThat(ClockHandsAngle.calcAngle(12, 59), is(354));
    }
}
