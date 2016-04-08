package com.cenerino.algorithms.java.graphs;

import java.util.*;

public class WeightedDirectedGraph<V> {

    private final Map<V, List<WeightedDirectedEdge<V>>> adjacencyLists = new HashMap<>();
    private final List<WeightedDirectedEdge<V>> directedEdges = new LinkedList<>();

    public boolean addVertex(V vertex) {
        return adjacencyLists.putIfAbsent(vertex, new LinkedList<>()) == null;
    }

    public void addEdge(WeightedDirectedEdge<V> e) {
        validateVertices(e.from(), e.to());
        adjacencyLists.get(e.from()).add(e);
        directedEdges.add(e);
    }

    public List<WeightedDirectedEdge<V>> adj(V v) {
        validateVertices(v);
        return Collections.unmodifiableList(adjacencyLists.get(v));
    }

    public List<WeightedDirectedEdge<V>> edges() {
        return Collections.unmodifiableList(directedEdges);
    }

    public Set<V> vertices() {
        return Collections.unmodifiableSet(adjacencyLists.keySet());
    }

    public int vertexCount() {
        return adjacencyLists.size();
    }

    public int edgeCount() {
        return directedEdges.size();
    }

    public int degree(V vertex) {
        validateVertices(vertex);
        return adjacencyLists.get(vertex).size();
    }

    protected void validateVertices(V... vertices) {
        for (V vertex : vertices) {
            if (!adjacencyLists.containsKey(vertex))
                throw new IllegalArgumentException("vertex " + vertex + " not found in the graph");
        }
    }
}
