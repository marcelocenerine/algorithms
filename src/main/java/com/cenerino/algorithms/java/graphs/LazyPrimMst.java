package com.cenerino.algorithms.java.graphs;

import java.util.*;

public class LazyPrimMst<V> {

    private final Queue<WeightedUndirectedEdge<V>> mst = new LinkedList<>();
    private double weight;
    private final Queue<WeightedUndirectedEdge<V>> queue = new PriorityQueue<>();
    private Set<V> visited;

    public static <V> LazyPrimMst<V> from(WeightedUndirectedGraph<V> graph) {
        return new LazyPrimMst<>(graph);
    }

    private LazyPrimMst(WeightedUndirectedGraph<V> graph) {
        visited = new HashSet<>(graph.vertexCount());

        for (V v : graph.vertices())
            if (!visited.contains(v)) prim(graph, v);
    }

    private void prim(WeightedUndirectedGraph<V> graph, V current) {
        visit(graph, current);

        while (!queue.isEmpty()) {
            WeightedUndirectedEdge<V> e = queue.remove();
            V v = e.either();
            V w = e.other(v);

            if (visited.contains(v) && visited.contains(w)) continue;

            mst.add(e);
            weight += e.weight();

            if (!visited.contains(v)) visit(graph, v);
            if (!visited.contains(w)) visit(graph, w);
        }
    }

    private void visit(WeightedUndirectedGraph<V> graph, V v) {
        visited.add(v);

        for (WeightedUndirectedEdge<V> e : graph.adj(v))
            if (!visited.contains(e.other(v))) queue.add(e);
    }

    public Collection<WeightedUndirectedEdge<V>> edges() {
        return Collections.unmodifiableCollection(mst);
    }

    public double weight() {
        return weight;
    }
}