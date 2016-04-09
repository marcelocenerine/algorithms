package com.cenerino.algorithms.java.graphs;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class WeightedUndirectedGraphTest {

    private WeightedUndirectedGraph<Integer> graph = new WeightedUndirectedGraph<>();

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

        WeightedUndirectedEdge<Integer> e = new WeightedUndirectedEdge<>(1, 2, 0.0);
        graph.addEdge(e);

        assertThat(graph.edgeCount(), is(1));
        assertThat(graph.adj(1), hasItems(e));
        assertThat(graph.adj(2), hasItems(e));
    }

    @Test
    public void shouldAddEdgeToItself() {
        graph.addVertex(1);

        WeightedUndirectedEdge<Integer> e = new WeightedUndirectedEdge<>(1, 1, 0.0);
        graph.addEdge(e);

        assertThat(graph.edgeCount(), is(1));
        assertThat(graph.adj(1), hasItems(e));
    }

    @Test
    public void shouldAddParallelEdges() {
        graph.addVertex(1);
        graph.addVertex(2);

        WeightedUndirectedEdge<Integer> e1 = new WeightedUndirectedEdge<>(1, 2, 0.0);
        WeightedUndirectedEdge<Integer> e2 = new WeightedUndirectedEdge<>(2, 1, 0.0);
        graph.addEdge(e1);
        graph.addEdge(e2);

        assertThat(graph.edgeCount(), is(2));
        assertThat(graph.adj(1), is(Arrays.asList(e1, e2)));
        assertThat(graph.adj(2), is(Arrays.asList(e1, e2)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAddEdgeIfFirstVertexDoesNotExist() {
        graph.addVertex(1);

        graph.addEdge(new WeightedUndirectedEdge<>(2, 1, 0.0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAddEdgeIfSecondVertexDoesNotExist() {
        graph.addVertex(1);

        graph.addEdge(new WeightedUndirectedEdge<>(1, 2, 0.0));
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

        graph.addEdge(new WeightedUndirectedEdge<>(1, 2, 0.0));
        graph.addEdge(new WeightedUndirectedEdge<>(1, 3, 0.0));

        assertThat(graph.degree(1), is(2));
        assertThat(graph.degree(2), is(1));
        assertThat(graph.degree(3), is(1));
    }

    @Test
    public void shouldReturnAllVertices() {
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);

        assertThat(graph.vertices(), hasItems(1, 2, 3));
    }

    @Test
    public void shouldReturnAllEdges() {
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);

        WeightedUndirectedEdge<Integer> e1 = new WeightedUndirectedEdge<>(1, 2, 0.0);
        WeightedUndirectedEdge<Integer> e2 = new WeightedUndirectedEdge<>(2, 3, 0.0);
        graph.addEdge(e1);
        graph.addEdge(e2);

        assertThat(graph.edges(), hasItems(e1, e2));
    }
}
