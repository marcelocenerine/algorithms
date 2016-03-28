package com.cenerino.algorithms.java.graphs;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DepthFirstPathsTest {

    private DepthFirstPaths<Integer> dfp;

    @Before
    public void setUp() {
        Graph<Integer> graph = new UndirectedGraph<>();
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
        graph.addEdge(0, 6);
        graph.addEdge(6, 4);
        graph.addEdge(4, 3);
        graph.addEdge(4, 5);
        graph.addEdge(5, 3);
        graph.addEdge(5, 0);

        dfp = DepthFirstPaths.from(graph, 0);
    }

    @Test
    public void shouldHavePath() {
        assertThat(dfp.hasPathTo(5), is(true));
    }

    @Test
    public void shouldReturnPath() {
        assertThat(dfp.pathTo(5), anyOf(is(asList(0, 6, 4, 3, 5)), is(asList(0, 6, 4, 5))));
    }

    @Test
    public void shouldNotHavePath() {
        assertThat(dfp.hasPathTo(7), is(false));
    }

    @Test
    public void shouldReturnEmptyPath() {
        assertThat(dfp.pathTo(7), is(emptyList()));
    }
}
