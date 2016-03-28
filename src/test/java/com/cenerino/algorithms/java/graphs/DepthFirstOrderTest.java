package com.cenerino.algorithms.java.graphs;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DepthFirstOrderTest {

    private DepthFirstOrder<Integer> dfo;

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
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 5);
        graph.addEdge(1, 4);
        graph.addEdge(5, 2);
        graph.addEdge(3, 2);
        graph.addEdge(3, 5);
        graph.addEdge(3, 4);
        graph.addEdge(3, 6);
        graph.addEdge(6, 0);
        graph.addEdge(6, 4);

        dfo = DepthFirstOrder.<Integer>from(graph);
    }

    @Test
    public void shouldReturnVerticesInTopologicalOrder() {
        Iterable<Integer> vertices = dfo.reversePost();

        assertThat(vertices, is(asList(3, 6, 0, 5, 2, 1, 4)));
    }
}
