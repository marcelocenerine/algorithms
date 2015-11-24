package com.cenerino.algorithms.java.math;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PowerOfTwoTest {

    @Test
    public void shouldBePowerOfTwo() {
        for (int n = 2; n <= 512; n *= 2) {
            assertThat(PowerOfTwo.isPowerOfTwo(n), is(true));
        }
    }

    @Test
    public void shouldNotBePowerOfTwo() {
        for (int n = 1; n < 512; n += 2) {
            assertThat(PowerOfTwo.isPowerOfTwo(n), is(false));
        }
    }

    @Test
    public void shouldGetNthPowerOfTwo() {
        assertThat(PowerOfTwo.getNthPowerOfTwo(1), is(2));
        assertThat(PowerOfTwo.getNthPowerOfTwo(2), is(4));
        assertThat(PowerOfTwo.getNthPowerOfTwo(3), is(8));
        assertThat(PowerOfTwo.getNthPowerOfTwo(4), is(16));
        assertThat(PowerOfTwo.getNthPowerOfTwo(5), is(32));
        assertThat(PowerOfTwo.getNthPowerOfTwo(6), is(64));
        assertThat(PowerOfTwo.getNthPowerOfTwo(7), is(128));
    }
}
