package com.cenerino.algorithms.java.graphs;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.either;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class WeightedDirectedEdgeTest {

    private WeightedDirectedEdge<Integer> directedEdge = new WeightedDirectedEdge<>(1, 2, 10);

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailToCreateIfWeightIsNegative() {
        new WeightedUndirectedEdge<String>("a", "b", -1);
    }

    @Test
    public void shouldReturnTheOriginVertex() {
        assertThat(directedEdge.from(), is(1));
    }

    @Test
    public void shouldReturnTheOppositeVertex() {
        assertThat(directedEdge.to(), is(2));
    }

    @Test
    public void shouldReturnWeight() {
        assertThat(directedEdge.weight(), is(10.0));
    }
}
