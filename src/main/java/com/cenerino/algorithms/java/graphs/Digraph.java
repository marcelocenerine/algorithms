package com.cenerino.algorithms.java.graphs;

public interface Digraph<V> extends Graph<V> {
    void addEdge(V source, V target);
}
