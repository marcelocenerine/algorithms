package com.cenerino.algorithms.search;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QuickUnionWithPathCompressionTest {

    private QuickUnionWithPathCompression qu;

    @Before
    public void setUp() {
        qu = new QuickUnionWithPathCompression(10);
    }

    @Test
    public void shouldNotBeConnected() {
        assertThat(qu.isConnected(0, 9), is(false));
    }

    @Test
    public void shouldBeConnected_reflexive() {
        assertThat(qu.isConnected(5, 5), is(true));
    }

    @Test
    public void shouldBeConnected_symmetric() {
        qu.union(3, 6);

        assertThat(qu.isConnected(3, 6), is(true));
        assertThat(qu.isConnected(6, 3), is(true));
    }

    @Test
    public void shouldBeConnected_transitive() {
        qu.union(3, 6);
        qu.union(6, 9);
        qu.union(9, 1);

        assertThat(qu.isConnected(3, 1), is(true));
    }
}
