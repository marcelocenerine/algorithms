package com.cenerino.algorithms.java.graphs;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.either;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class WeightedUndirectedEdgeTest {

    private WeightedUndirectedEdge<Integer> undirectedEdge = new WeightedUndirectedEdge<>(1, 2, 10);

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailToCreateIfWeightIsNegative() {
        new WeightedUndirectedEdge<String>("a", "b", -1);
    }

    @Test
    public void shouldReturnOneOfTheVertices() {
        assertThat(undirectedEdge.either(), either(is(1)).or(is(2)));
    }

    @Test
    public void shouldReturnTheOppositeVertex() {
        assertThat(undirectedEdge.other(1), is(2));
        assertThat(undirectedEdge.other(2), is(1));
    }

    @Test
    public void shouldReturnWeight() {
        assertThat(undirectedEdge.weight(), is(10.0));
    }
}
