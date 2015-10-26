package com.cenerino.algorithms.java.search;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BinarySearchTest {

    @Test
    public void shouldFindElementInArrayWithSizeOne() {
        Integer[] array = { 3 };

        assertThat(BinarySearch.search(array, 3), is(0));
    }

    @Test
    public void shouldFindElementInArrayWithMultipleElements() {
        Integer[] array = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        assertThat(BinarySearch.search(array, 8), is(8));
    }

    @Test
    public void shouldNotFindElementInEmptyArray() {
        Integer[] array = { };

        assertThat(BinarySearch.search(array, 100), is(-1));
    }

    @Test
    public void shouldNotFindElementInArrayWithMultipleElements() {
        Integer[] array = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        assertThat(BinarySearch.search(array, 100), is(-11));
    }

    @Test
    public void shouldFindElementInArrayContainingDuplicateElements() {
        Integer[] array = { 5, 5, 5 };

        assertThat(BinarySearch.search(array, 5), is(1));
    }
}
