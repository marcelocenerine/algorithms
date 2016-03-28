package com.cenerino.algorithms.java.graphs;

public class DirectedGraph<V> extends AbstractGraph<V> {

    @Override
    public void addEdge(V source, V target) {
        validateVertices(source, target);
        adjacencyLists.get(source).add(target);
        edgeCount++;
    }
}
