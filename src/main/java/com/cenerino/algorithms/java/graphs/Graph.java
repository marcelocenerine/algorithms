package com.cenerino.algorithms.java.graphs;

import java.util.List;

public interface Graph<V> {

    boolean addVertex(V vertex);
    void addEdge(V source, V target);
    List<V> adj(V vertex);
    int vertices();
    int edges();
    int degree(V vertex);
}
