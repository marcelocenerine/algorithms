package com.cenerino.algorithms.selection;

import com.cenerino.algorithms.sort.QuickSort;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QuickSelectionTest {

    @Test
    public void shouldFindKElement() {
        Integer[] array = {10, 5, 9, 1, 3, 0, -1, 5, 8, 15, 4, 7, -6};

        Integer result = QuickSelection.select(array, 5);

        assertThat(result, is(4));
    }
}
