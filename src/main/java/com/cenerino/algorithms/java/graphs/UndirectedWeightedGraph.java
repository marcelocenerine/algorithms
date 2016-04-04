package com.cenerino.algorithms.java.graphs;

import java.util.*;

public class UndirectedWeightedGraph<V> {

    private final Map<V, List<Edge<V>>> adjacencyLists = new HashMap<>();
    private final List<Edge<V>> edges = new LinkedList<>();

    public boolean addVertex(V vertex) {
        return adjacencyLists.putIfAbsent(vertex, new LinkedList<>()) == null;
    }

    public void addEdge(Edge<V> e) {
        V v = e.either();
        V w = e.other(v);
        validateVertices(v, w);
        adjacencyLists.get(v).add(e);
        adjacencyLists.get(w).add(e);
        edges.add(e);
    }

    public List<Edge<V>> adj(V v) {
        validateVertices(v);
        return Collections.unmodifiableList(adjacencyLists.get(v));
    }

    public List<Edge<V>> edges() {
        return Collections.unmodifiableList(edges);
    }

    public Set<V> vertices() {
        return Collections.unmodifiableSet(adjacencyLists.keySet());
    }

    public int vertexCount() {
        return adjacencyLists.size();
    }

    public int edgeCount() {
        return edges.size();
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
