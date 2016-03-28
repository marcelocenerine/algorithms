package com.cenerino.algorithms.java.graphs;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SimpleDirectedGraphTest {

    private Digraph<Integer> graph = new SimpleDirectedGraph<>();

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
        assertThat(graph.adj(1), is(asList(2, 2)));
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

    @Test
    public void shouldReverseGraph() {
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);

        Digraph<Integer> reverse = graph.reverse();

        assertThat(reverse.vertices(), hasItems(1, 2, 3, 4, 5));
        assertThat(reverse.adj(1), is(emptyList()));
        assertThat(reverse.adj(2), is(asList(1)));
        assertThat(reverse.adj(3), is(asList(1)));
        assertThat(reverse.adj(4), is(asList(1)));
        assertThat(reverse.adj(5), is(asList(3, 4)));
    }
}
