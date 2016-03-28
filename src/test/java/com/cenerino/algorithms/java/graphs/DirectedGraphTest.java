package com.cenerino.algorithms.java.graphs;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static java.util.Collections.emptyList;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DirectedGraphTest {

    private Graph<Integer> graph = new DirectedGraph<>();

    @Test
    public void shouldAddVertex() {
        assertThat(graph.addVertex(1), is(true));
        assertThat(graph.vertexCount(), is(1));
    }

    @Test
    public void shouldNotAddVertexIfItAlreadyExists() {
        graph.addVertex(2);

        assertThat(graph.addVertex(2), is(false));
        assertThat(graph.vertexCount(), is(1));
    }

    @Test
    public void shouldAddEdge() {
        graph.addVertex(1);
        graph.addVertex(2);

        graph.addEdge(1, 2);

        assertThat(graph.edgeCount(), is(1));
        assertThat(graph.adj(1), hasItems(2));
        assertThat(graph.adj(2), is(emptyList()));
    }

    @Test
    public void shouldAddEdgeToItself() {
        graph.addVertex(1);

        graph.addEdge(1, 1);

        assertThat(graph.edgeCount(), is(1));
        assertThat(graph.adj(1), hasItems(1));
    }

    @Test
    public void shouldAddParallelEdges() {
        graph.addVertex(1);
        graph.addVertex(2);

        graph.addEdge(1, 2);
        graph.addEdge(1, 2);

        assertThat(graph.edgeCount(), is(2));
        assertThat(graph.adj(1), is(Arrays.asList(2, 2)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAddEdgeIfSourceVertexDoesNotExist() {
        graph.addVertex(1);

        graph.addEdge(2, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAddEdgeIfTargetVertexDoesNotExist() {
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
        assertThat(graph.degree(2), is(0));
        assertThat(graph.degree(3), is(0));
    }

    @Test
    public void shouldReturnAllVertices() {
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);

        assertThat(graph.vertices(), hasItems(1, 2, 3));
    }
}
