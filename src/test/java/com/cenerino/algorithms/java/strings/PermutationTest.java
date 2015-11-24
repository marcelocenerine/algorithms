package com.cenerino.algorithms.java.strings;

import com.google.common.collect.Sets;
import org.junit.Test;

import static com.google.common.collect.Sets.newHashSet;
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

    @Test
    public void shouldReturnPermutationsOfStringOfSizeOne() {
        assertThat(Permutation.generatePermutations("a"), is(newHashSet("a")));
    }

    @Test
    public void shouldReturnPermutationsOfStringWithDuplicateCharacters() {
        assertThat(Permutation.generatePermutations("aaab"), is(newHashSet("aaab", "aaba", "abaa", "baaa")));
    }

    @Test
    public void shouldReturnPermutationsOfStringWithNonDuplicateCharacters() {
        assertThat(Permutation.generatePermutations("mar"), is(newHashSet("amr", "arm", "mar", "mra", "ram", "rma")));
    }
}
