package com.cenerino.algorithms.java.graphs;

import java.util.*;

import static java.util.Collections.unmodifiableSet;

abstract class AbstractGraph<V> implements Graph<V> {

    protected Map<V, List<V>> adjacencyLists = new HashMap<>();
    protected int edgeCount;

    @Override
    public boolean addVertex(V vertex) {
        return adjacencyLists.putIfAbsent(vertex, new LinkedList<>()) == null;
    }

    @Override
    public List<V> adj(V vertex) {
        validateVertices(vertex);
        return adjacencyLists.get(vertex);
    }

    @Override
    public int vertexCount() {
        return adjacencyLists.size();
    }

    @Override
    public int degree(V vertex) {
        validateVertices(vertex);
        return adjacencyLists.get(vertex).size();
    }

    @Override
    public Set<V> vertices() {
        return unmodifiableSet(adjacencyLists.keySet());
    }

    protected void validateVertices(V... vertices) {
        for (V vertex : vertices) {
            if (!adjacencyLists.containsKey(vertex))
                throw new IllegalArgumentException("vertex " + vertex + " not found in the graph");
        }
    }

    @Override
    public int edgeCount() {
        return edgeCount;
    }
}
