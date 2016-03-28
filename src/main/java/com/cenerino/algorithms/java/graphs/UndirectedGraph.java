package com.cenerino.algorithms.java.graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class UndirectedGraph <V> implements Graph<V> {

    private Map<V, List<V>> adjencyLists = new HashMap<>();
    private int edgesCount;

    @Override
    public boolean addVertex(V vertex) {
        if (adjencyLists.containsKey(vertex)) return false;

        adjencyLists.put(vertex, new LinkedList<>());
        return true;
    }

    // Allows anomalies: self-loop and parallel edges
    @Override
    public void addEdge(V source, V target) {
        validateVertex(source);
        validateVertex(target);
        adjencyLists.get(source).add(target);
        adjencyLists.get(target).add(source);
        edgesCount++;
    }

    private void validateVertex(V vertex) {
        if (!adjencyLists.containsKey(vertex))
            throw new IllegalArgumentException("vertex " + vertex + " not found in the graph");
    }

    @Override
    public List<V> adj(V vertex) {
        validateVertex(vertex);
        return adjencyLists.get(vertex);
    }

    @Override
    public int vertices() {
        return adjencyLists.size();
    }

    @Override
    public int edges() {
        return edgesCount;
    }

    @Override
    public int degree(V vertex) {
        validateVertex(vertex);
        return adjencyLists.get(vertex).size();
    }
}
