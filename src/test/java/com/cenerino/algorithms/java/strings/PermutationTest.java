package com.cenerino.algorithms.java.strings;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PermutationTest {

    @Test
    public void shouldBePermutation() {
        assertThat(Permutation.isPermutation("abcd", "adcb"), is(true));
    }
    @Test
    public void shouldNotBePermutation() {
        assertThat(Permutation.isPermutation("abcd", "aacb"), is(false));
    }
}
