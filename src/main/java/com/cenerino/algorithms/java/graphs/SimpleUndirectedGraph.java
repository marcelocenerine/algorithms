package com.cenerino.algorithms.java.graphs;

public class SimpleUndirectedGraph<V> extends AbstractGraph<V> {

    @Override
    public void addEdge(V v1, V v2) {
        validateVertices(v1, v2);
        adjacencyLists.get(v1).add(v2);
        adjacencyLists.get(v2).add(v1);
        edgeCount++;
    }
}
