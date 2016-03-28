package com.cenerino.algorithms.java.graphs;

import java.util.List;
import java.util.Set;

public interface Graph<V> {

    boolean addVertex(V vertex);
    void addEdge(V vertex1, V vertex2);
    List<V> adj(V vertex);
    int vertexCount();
    int edgeCount();
    int degree(V vertex);
    Set<V> vertices();
}
