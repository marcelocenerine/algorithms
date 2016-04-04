package com.cenerino.algorithms.java.graphs;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.either;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class EdgeTest {

    private Edge<Integer> edge = new Edge<>(1, 2, 10);

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailToCreateIfWeightIsNegative() {
        new Edge<String>("a", "b", -1);
    }

    @Test
    public void shouldReturnOneOfTheVertices() {
        assertThat(edge.either(), either(is(1)).or(is(2)));
    }

    @Test
    public void shouldReturnTheOppositeVertex() {
        assertThat(edge.other(1), is(2));
        assertThat(edge.other(2), is(1));
    }

    @Test
    public void shouldReturnWeight() {
        assertThat(edge.weight(), is(10.0));
    }
}
