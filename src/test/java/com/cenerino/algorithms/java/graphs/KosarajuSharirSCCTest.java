package com.cenerino.algorithms.java.graphs;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class KosarajuSharirSCCTest {

    private KosarajuSharirSCC<Integer> scc;

    @Before
    public void setUp() {
        Digraph<Integer> graph = new SimpleDirectedGraph<>();
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);
        graph.addVertex(7);
        graph.addVertex(8);
        graph.addVertex(9);
        graph.addVertex(10);
        graph.addVertex(11);
        graph.addVertex(12);

        graph.addEdge(0, 1);
        graph.addEdge(0, 5);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 2);
        graph.addEdge(3, 5);
        graph.addEdge(4, 2);
        graph.addEdge(4, 3);
        graph.addEdge(5, 4);
        graph.addEdge(6, 0);
        graph.addEdge(6, 4);
        graph.addEdge(6, 8);
        graph.addEdge(6, 9);
        graph.addEdge(7, 6);
        graph.addEdge(7, 9);
        graph.addEdge(8, 6);
        graph.addEdge(9, 10);
        graph.addEdge(9, 11);
        graph.addEdge(10, 12);
        graph.addEdge(11, 4);
        graph.addEdge(11, 12);
        graph.addEdge(12, 9);

        scc = KosarajuSharirSCC.from(graph);
    }

    @Test
    public void shouldBeConnected() {
        assertThat(scc.stronglyConnected(9, 12), is(true));
    }

    @Test
    public void shouldNotBeConnected() {
        assertThat(scc.stronglyConnected(4, 11), is(false));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailToCheckWhetherTwoVerticesAreConnectedIfSourceIsNotInTheGraph() {
        scc.stronglyConnected(100, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailToCheckWhetherTwoVerticesAreConnectedIfTargetIsNotInTheGraph() {
        scc.stronglyConnected(0, 100);
    }

    @Test
    public void shouldReturnNumberOfComponents() {
        assertThat(scc.count(), is(5));
    }

    @Test
    public void shouldReturnNumberOfVerticesInTheComponent() {
        assertThat(scc.size(1), is(1));
        assertThat(scc.size(0), is(5));
        assertThat(scc.size(9), is(4));
        assertThat(scc.size(6), is(2));
        assertThat(scc.size(7), is(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailToReturnNumberOfVerticesInTheComponentIfVertexIsNotInTheGraph() {
        scc.size(100);
    }
}
