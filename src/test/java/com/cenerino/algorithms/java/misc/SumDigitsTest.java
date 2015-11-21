package com.cenerino.algorithms.java.misc;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SumDigitsTest {

    @Test
    public void shouldSumDigitsOfZero() {
        assertThat(SumDigits.calc(0), is(0));
    }

    @Test
    public void shouldSumDigitsOfSingleDigitNumber() {
        assertThat(SumDigits.calc(9), is(9));
    }

    @Test
    public void shouldSumDigitsOfTwoDigitsNumber() {
        assertThat(SumDigits.calc(79), is(16));
    }

    @Test
    public void shouldSumDigitsOfLongNumber() {
        assertThat(SumDigits.calc(1234567890), is(45));
    }

    @Test
    public void shouldSumDigitsOfNegativeNumber() {
        assertThat(SumDigits.calc(-987), is(24));
    }
}
