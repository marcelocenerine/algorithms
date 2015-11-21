package com.cenerino.algorithms.java.strings;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UniqueCharactersTest {

    @Test
    public void shouldHaveUniqueCharacters() {
        assertThat(UniqueCharacters.verify("abcdefg"), is(true));
    }

    @Test
    public void shouldNotHaveUniqueCharacters() {
        assertThat(UniqueCharacters.verify("abcdefga"), is(false));
    }
}
