package com.cenerino.algorithms.java.uf;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class WeightedQuickUnionTest {

    private WeightedQuickUnion wqu;

    @Before
    public void setUp() {
        wqu = new WeightedQuickUnion(10);
    }

    @Test
    public void shouldNotBeConnected() {
        assertThat(wqu.isConnected(0, 9), is(false));
    }

    @Test
    public void shouldBeConnected_reflexive() {
        assertThat(wqu.isConnected(5, 5), is(true));
    }

    @Test
    public void shouldBeConnected_symmetric() {
        wqu.union(3, 6);

        assertThat(wqu.isConnected(3, 6), is(true));
        assertThat(wqu.isConnected(6, 3), is(true));
    }

    @Test
    public void shouldBeConnected_transitive() {
        wqu.union(3, 6);
        wqu.union(6, 9);
        wqu.union(9, 1);

        assertThat(wqu.isConnected(3, 1), is(true));
    }
}
