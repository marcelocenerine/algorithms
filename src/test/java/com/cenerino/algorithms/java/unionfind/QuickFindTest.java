package com.cenerino.algorithms.java.unionfind;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QuickFindTest {

    private UnionFind qf;

    @Before
    public void setUp() {
        qf = new QuickFind(10);
    }

    @Test
    public void shouldNotBeConnected() {
        assertThat(qf.isConnected(0, 9), is(false));
    }

    @Test
    public void shouldBeConnected_reflexive() {
        assertThat(qf.isConnected(5, 5), is(true));
    }

    @Test
    public void shouldBeConnected_symmetric() {
        qf.union(3, 6);

        assertThat(qf.isConnected(3, 6), is(true));
        assertThat(qf.isConnected(6, 3), is(true));
    }

    @Test
    public void shouldBeConnected_transitive() {
        qf.union(3, 6);
        qf.union(6, 9);
        qf.union(9, 1);

        assertThat(qf.isConnected(3, 1), is(true));
    }
}
