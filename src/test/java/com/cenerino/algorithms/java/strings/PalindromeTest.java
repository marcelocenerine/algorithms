package com.cenerino.algorithms.java.strings;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PalindromeTest {

    @Test
    public void shouldWordBePalindrome() {
        assertThat(Palindrome.isPalindromeWord("anna"), is(true));
    }

    @Test
    public void shouldWordWithDifferentCaseBePalindrome() {
        assertThat(Palindrome.isPalindromeWord("Racecar"), is(true));
    }

    @Test
    public void shouldWordNotBePalindrome() {
        assertThat(Palindrome.isPalindromeWord("purple"), is(false));
    }
}
