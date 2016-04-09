package com.cenerino.algorithms.java.graphs;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.stream.IntStream;

import static java.lang.Double.POSITIVE_INFINITY;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DijkstraShortestPathTest {

    private WeightedDirectedGraph<Integer> graph;
    private DijkstraShortestPath dsp;

    @Before
    public void setUp() {
        graph  = new WeightedDirectedGraph<>();
        IntStream.rangeClosed(0, 8).forEach(v -> graph.addVertex(v));

        graph.addEdge(new WeightedDirectedEdge<>(0, 1, 5.0));
        graph.addEdge(new WeightedDirectedEdge<>(0, 4, 9.0));
        graph.addEdge(new WeightedDirectedEdge<>(0, 7, 8.0));
        graph.addEdge(new WeightedDirectedEdge<>(1, 2, 12.0));
        graph.addEdge(new WeightedDirectedEdge<>(1, 3, 15.0));
        graph.addEdge(new WeightedDirectedEdge<>(1, 7, 4.0));
        graph.addEdge(new WeightedDirectedEdge<>(2, 3, 3.0));
        graph.addEdge(new WeightedDirectedEdge<>(2, 6, 11.0));
        graph.addEdge(new WeightedDirectedEdge<>(3, 6, 9.0));
        graph.addEdge(new WeightedDirectedEdge<>(4, 5, 4.0));
        graph.addEdge(new WeightedDirectedEdge<>(4, 6, 20.0));
        graph.addEdge(new WeightedDirectedEdge<>(4, 7, 5.0));
        graph.addEdge(new WeightedDirectedEdge<>(5, 2, 1.0));
        graph.addEdge(new WeightedDirectedEdge<>(5, 6, 13.0));
        graph.addEdge(new WeightedDirectedEdge<>(7, 5, 6.0));
        graph.addEdge(new WeightedDirectedEdge<>(7, 2, 7.0));

        dsp = DijkstraShortestPath.from(graph, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailIfSourceIsNotInTheGraph() {
        DijkstraShortestPath.from(graph, 99);
    }

    @Test
    public void shouldHavePathTo() {
        assertThat(dsp.hasPathTo(6), is(true));
    }

    @Test
    public void shouldNotHavePathTo() {
        assertThat(dsp.hasPathTo(8), is(false));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailIfVertexInformedForHasPathToIsNotInTheGraph() {
        dsp.hasPathTo(99);
    }

    @Test
    public void shouldFindDistanceTo() {
        assertThat(dsp.distanceTo(0), is(0.0));
        assertThat(dsp.distanceTo(1), is(5.0));
        assertThat(dsp.distanceTo(2), is(14.0));
        assertThat(dsp.distanceTo(3), is(17.0));
        assertThat(dsp.distanceTo(4), is(9.0));
        assertThat(dsp.distanceTo(5), is(13.0));
        assertThat(dsp.distanceTo(6), is(25.0));
        assertThat(dsp.distanceTo(7), is(8.0));
    }

    @Test
    public void shouldNotFindDistanceTo() {
        assertThat(dsp.distanceTo(8), is(POSITIVE_INFINITY));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailIfVertexInformedForDistanceToIsNotInTheGraph() {
        dsp.distanceTo(99);
    }

    @Test
    public void shouldReturnPathTo() {
        Iterator<WeightedDirectedEdge<Integer>> path = dsp.pathTo(6).iterator();

        WeightedDirectedEdge<Integer> edge = path.next();
        assertThat(edge.from(), is(0));
        assertThat(edge.to(), is(4));
        edge = path.next();
        assertThat(edge.from(), is(4));
        assertThat(edge.to(), is(5));
        edge = path.next();
        assertThat(edge.from(), is(5));
        assertThat(edge.to(), is(2));
        edge = path.next();
        assertThat(edge.from(), is(2));
        assertThat(edge.to(), is(6));
    }

    @Test
    public void shouldNotReturnPathTo() {
        assertThat(dsp.pathTo(8).iterator().hasNext(), is(false));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailIfVertexInformedForPathToIsNotInTheGraph() {
        dsp.pathTo(99);
    }
}
