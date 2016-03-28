package com.cenerino.algorithms.java.graphs;

public class SimpleDirectedGraph<V> extends AbstractGraph<V> implements Digraph<V> {

    @Override
    public void addEdge(V source, V target) {
        validateVertices(source, target);
        adjacencyLists.get(source).add(target);
        edgeCount++;
    }
}
