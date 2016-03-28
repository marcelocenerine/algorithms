package com.cenerino.algorithms.java.graphs;

import java.util.*;

import static java.util.Collections.unmodifiableSet;

public class UndirectedGraph <V> implements Graph<V> {

    private Map<V, List<V>> adjacencyLists = new HashMap<>();
    private int edgeCount;

    @Override
    public boolean addVertex(V vertex) {
        if (adjacencyLists.containsKey(vertex)) return false;

        adjacencyLists.put(vertex, new LinkedList<>());
        return true;
    }

    // Allows anomalies: self-loop and parallel edgeCount
    @Override
    public void addEdge(V vertex1, V vertex2) {
        validateVertex(vertex1);
        validateVertex(vertex2);
        adjacencyLists.get(vertex1).add(vertex2);
        adjacencyLists.get(vertex2).add(vertex1);
        edgeCount++;
    }

    private void validateVertex(V vertex) {
        if (!adjacencyLists.containsKey(vertex))
            throw new IllegalArgumentException("vertex " + vertex + " not found in the graph");
    }

    @Override
    public List<V> adj(V vertex) {
        validateVertex(vertex);
        return adjacencyLists.get(vertex);
    }

    @Override
    public int vertexCount() {
        return adjacencyLists.size();
    }

    @Override
    public int edgeCount() {
        return edgeCount;
    }

    @Override
    public int degree(V vertex) {
        validateVertex(vertex);
        return adjacencyLists.get(vertex).size();
    }

    @Override
    public Set<V> vertices() {
        return unmodifiableSet(adjacencyLists.keySet());
    }
}
