package com.cenerino.algorithms.java.graphs;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ConnectedComponentsTest {

    private ConnectedComponents<Integer> cc;

    @Before
    public void setUp() {
        Graph<Integer> graph = new SimpleUndirectedGraph<>();
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);
        graph.addVertex(7);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 7);

        cc = ConnectedComponents.from(graph);
    }

    @Test
    public void shouldBeConnected() {
        assertThat(cc.connected(3, 7), is(true));
    }

    @Test
    public void shouldNotBeConnected() {
        assertThat(cc.connected(0, 7), is(false));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailToCheckWhetherTwoVerticesAreConnectedIfSourceIsNotInTheGraph() {
        cc.connected(100, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailToCheckWhetherTwoVerticesAreConnectedIfTargetIsNotInTheGraph() {
        cc.connected(0, 100);
    }

    @Test
    public void shouldReturnNumberOfComponents() {
        assertThat(cc.count(), is(2));
    }

    @Test
    public void shouldReturnNumberOfVerticesInTheComponent() {
        assertThat(cc.size(0), is(3));
        assertThat(cc.size(5), is(5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailToReturnNumberOfVerticesInTheComponentIfVertexIsNotInTheGraph() {
        cc.size(100);
    }
}
