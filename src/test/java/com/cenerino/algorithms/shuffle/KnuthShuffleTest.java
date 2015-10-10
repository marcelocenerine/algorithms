package com.cenerino.algorithms.shuffle;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.matchers.JUnitMatchers;

import java.util.Arrays;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class KnuthShuffleTest {

    @Test
    public void shouldShuffleElements() {
        Integer[] original = {1, 2, 3, 4, 5 , 6};
        Integer[] shuffled = original.clone();
        KnuthShuffle.shuffle(shuffled);

        assertThat(shuffled, not(original));
        assertThat(asList(shuffled), hasItems(original));
    }
}
