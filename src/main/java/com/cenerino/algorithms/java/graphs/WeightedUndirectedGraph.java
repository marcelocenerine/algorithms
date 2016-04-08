package com.cenerino.algorithms.java.graphs;

import java.util.*;

public class WeightedUndirectedGraph<V> {

    private final Map<V, List<WeightedUndirectedEdge<V>>> adjacencyLists = new HashMap<>();
    private final List<WeightedUndirectedEdge<V>> undirectedEdges = new LinkedList<>();

    public boolean addVertex(V vertex) {
        return adjacencyLists.putIfAbsent(vertex, new LinkedList<>()) == null;
    }

    public void addEdge(WeightedUndirectedEdge<V> e) {
        V v = e.either();
        V w = e.other(v);
        validateVertices(v, w);
        adjacencyLists.get(v).add(e);
        adjacencyLists.get(w).add(e);
        undirectedEdges.add(e);
    }

    public List<WeightedUndirectedEdge<V>> adj(V v) {
        validateVertices(v);
        return Collections.unmodifiableList(adjacencyLists.get(v));
    }

    public List<WeightedUndirectedEdge<V>> edges() {
        return Collections.unmodifiableList(undirectedEdges);
    }

    public Set<V> vertices() {
        return Collections.unmodifiableSet(adjacencyLists.keySet());
    }

    public int vertexCount() {
        return adjacencyLists.size();
    }

    public int edgeCount() {
        return undirectedEdges.size();
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
