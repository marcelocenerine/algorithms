package com.cenerino.algorithms.java.strings;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CompressionTest {

    @Test
    public void shouldCompressString() {
        assertThat(Compression.compress("aabcccccaaa"), is("a2b1c5a3"));
        assertThat(Compression.compress("accccccca"), is("a1c7a1"));
    }

    @Test
    public void shouldCompressEmptyString() {
        assertThat(Compression.compress(""), is(""));
    }

    @Test
    public void shouldCompressStringOfSizeOne() {
        assertThat(Compression.compress("a"), is("a"));
    }

    @Test
    public void shouldNotCompressString() {
        assertThat(Compression.compress("abcdefgh"), is("abcdefgh"));
    }
}
