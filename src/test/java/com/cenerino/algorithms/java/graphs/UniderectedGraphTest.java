package com.cenerino.algorithms.java.graphs;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UniderectedGraphTest {

    private Graph<Integer> graph = new UndirectedGraph<>();

    @Test
    public void shouldAddVertex() {
        assertThat(graph.addVertex(1), is(true));
        assertThat(graph.vertices(), is(1));
    }

    @Test
    public void shouldNotAddVertexIfItAlreadyExists() {
        graph.addVertex(2);

        assertThat(graph.addVertex(2), is(false));
        assertThat(graph.vertices(), is(1));
    }

    @Test
    public void shouldAddEdge() {
        graph.addVertex(1);
        graph.addVertex(2);

        graph.addEdge(1, 2);

        assertThat(graph.edges(), is(1));
        assertThat(graph.adj(1), hasItems(2));
        assertThat(graph.adj(2), hasItems(1));
    }

    @Test
    public void shouldAddEdgeToItself() {
        graph.addVertex(1);

        graph.addEdge(1, 1);

        assertThat(graph.edges(), is(1));
        assertThat(graph.adj(1), hasItems(1));
    }

    @Test
    public void shouldAddParallelEdges() {
        graph.addVertex(1);
        graph.addVertex(2);

        graph.addEdge(1, 2);
        graph.addEdge(2, 1);

        assertThat(graph.edges(), is(2));
        assertThat(graph.adj(1), is(Arrays.asList(2, 2)));
        assertThat(graph.adj(2), is(Arrays.asList(1, 1)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAddEdgeIfSourceDoesNotExist() {
        graph.addVertex(1);

        graph.addEdge(2, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAddEdgeIfTargetDoesNotExist() {
        graph.addVertex(1);

        graph.addEdge(1, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailToReturnAdjacentVerticesIfVertexDoesNotExist() {
        graph.adj(1);
    }

    @Test
    public void shouldReturnDegreeOfVertex() {
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);

        graph.addEdge(1, 2);
        graph.addEdge(1, 3);

        assertThat(graph.degree(1), is(2));
        assertThat(graph.degree(2), is(1));
        assertThat(graph.degree(3), is(1));
    }
}
