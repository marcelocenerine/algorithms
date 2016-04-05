package com.cenerino.algorithms.java.graphs;

import java.util.*;

public class LazyPrimMst<V> {

    private final Queue<Edge<V>> mst = new LinkedList<>();
    private double weight;
    private final Queue<Edge<V>> queue = new PriorityQueue<>();
    private Set<V> visited;

    public static <V> LazyPrimMst<V> from(UndirectedWeightedGraph<V> graph) {
        return new LazyPrimMst<>(graph);
    }

    private LazyPrimMst(UndirectedWeightedGraph<V> graph) {
        visited = new HashSet<>(graph.vertexCount());

        for (V v : graph.vertices())
            if (!visited.contains(v)) prim(graph, v);
    }

    private void prim(UndirectedWeightedGraph<V> graph, V current) {
        visit(graph, current);

        while (!queue.isEmpty()) {
            Edge<V> e = queue.remove();
            V v = e.either();
            V w = e.other(v);

            if (visited.contains(v) && visited.contains(w)) continue;

            mst.add(e);
            weight += e.weight();

            if (!visited.contains(v)) visit(graph, v);
            if (!visited.contains(w)) visit(graph, w);
        }
    }

    private void visit(UndirectedWeightedGraph<V> graph, V v) {
        visited.add(v);

        for (Edge<V> e : graph.adj(v))
            if (!visited.contains(e.other(v))) queue.add(e);
    }

    public Collection<Edge<V>> edges() {
        return Collections.unmodifiableCollection(mst);
    }

    public double weight() {
        return weight;
    }
}