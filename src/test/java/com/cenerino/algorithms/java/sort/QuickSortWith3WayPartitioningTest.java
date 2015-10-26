package com.cenerino.algorithms.java.sort;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QuickSortWith3WayPartitioningTest {

    @Test
    public void shouldSortDistinctElements() {
        Integer[] array = {10, 5, 9, 1, 3, 0, -1, 5, 8, 15, 4, 7, -6};

        QuickSortWith3WayPartitioning.sort(array);

        assertThat(array, is(new Integer[]{-6, -1, 0, 1, 3, 4, 5, 5, 7, 8, 9, 10, 15}));
    }

    @Test
    public void shouldSortDuplicateElements() {
        Integer[] array = {10, 4, 9, 1, 9, 0, 9, 5, 4};

        QuickSortWith3WayPartitioning.sort(array);

        assertThat(array, is(new Integer[]{0, 1, 4, 4, 5, 9, 9, 9, 10}));
    }

    @Test
    public void shouldSortArrayWithSingleElement() {
        Integer[] array = {1};

        QuickSortWith3WayPartitioning.sort(array);

        assertThat(array, is(array));
    }

    @Test
    public void shouldSortEmptyArray() {
        Integer[] array = {};

        QuickSortWith3WayPartitioning.sort(array);

        assertThat(array, is(array));
    }
}
