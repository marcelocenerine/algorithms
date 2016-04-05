package com.cenerino.algorithms.java.graphs;

import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LazyPrimMstTest {

    private Edge<Integer> e_0_2 = new Edge<>(0, 2, 0.26);
    private Edge<Integer> e_0_4 = new Edge<>(0, 4, 0.38);
    private Edge<Integer> e_0_6 = new Edge<>(0, 6, 0.58);
    private Edge<Integer> e_0_7 = new Edge<>(0, 7, 0.16);
    private Edge<Integer> e_1_2 = new Edge<>(1, 2, 0.36);
    private Edge<Integer> e_1_3 = new Edge<>(1, 3, 0.29);
    private Edge<Integer> e_1_5 = new Edge<>(1, 5, 0.32);
    private Edge<Integer> e_1_7 = new Edge<>(1, 7, 0.19);
    private Edge<Integer> e_2_3 = new Edge<>(2, 3, 0.17);
    private Edge<Integer> e_2_6 = new Edge<>(2, 6, 0.40);
    private Edge<Integer> e_2_7 = new Edge<>(2, 7, 0.34);
    private Edge<Integer> e_3_6 = new Edge<>(3, 6, 0.52);
    private Edge<Integer> e_4_5 = new Edge<>(4, 5, 0.35);
    private Edge<Integer> e_4_6 = new Edge<>(4, 6, 0.93);
    private Edge<Integer> e_4_7 = new Edge<>(4, 7, 0.37);
    private Edge<Integer> e_5_7 = new Edge<>(5, 7, 0.28);
    private LazyPrimMst<Integer> primMst;

    @Before
    public void setUp() {
        UndirectedWeightedGraph<Integer> graph = new UndirectedWeightedGraph<>();
        IntStream.rangeClosed(0, 7).forEach(v -> graph.addVertex(v));
        graph.addEdge(e_0_2);
        graph.addEdge(e_0_4);
        graph.addEdge(e_0_6);
        graph.addEdge(e_0_7);
        graph.addEdge(e_1_2);
        graph.addEdge(e_1_3);
        graph.addEdge(e_1_5);
        graph.addEdge(e_1_7);
        graph.addEdge(e_2_3);
        graph.addEdge(e_2_6);
        graph.addEdge(e_2_7);
        graph.addEdge(e_3_6);
        graph.addEdge(e_4_5);
        graph.addEdge(e_4_6);
        graph.addEdge(e_4_7);
        graph.addEdge(e_5_7);
        primMst =  LazyPrimMst.from(graph);
    }

    @Test
    public void shouldReturnEdgesInTheMinimumSpanningTree() {
        assertThat(primMst.edges().size(), is(7));
        assertThat(primMst.edges(), hasItems(e_4_5, e_5_7, e_1_7, e_0_7, e_0_2, e_2_3, e_2_6));
    }

    @Test
    public void shouldReturnWeightOfTheMinimumSpanningTree() {
        assertThat(primMst.weight(), is(1.81));
    }
}
