package com.cenerino.algorithms.java.strings;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ReverseTest {

    @Test
    public void shouldReverseStringWithEvenSize() {
        assertThat(Reverse.reverse("blue"), is("eulb"));
    }

    @Test
    public void shouldReverseStringWithOddSize() {
        assertThat(Reverse.reverse("red"), is("der"));
    }

    @Test
    public void shouldReverseStringWithSingleCharacter() {
        assertThat(Reverse.reverse("a"), is("a"));
    }

    @Test
    public void shouldReverseEmptyString() {
        assertThat(Reverse.reverse(""), is(""));
    }
}
