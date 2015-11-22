package com.cenerino.algorithms.java.strings;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RotationTest {

    @Test
    public void shouldBeRotation() {
        assertThat(Rotation.isRotation("waterbottle", "erbottlewat"), is(true));
    }
    @Test
    public void shouldNotBeRotation() {
        assertThat(Rotation.isRotation("abcd", "acbd"), is(false));
    }
}
