package com.cenerino.algorithms.java.graphs;

import com.cenerino.algorithms.java.collections.FibonacciHeap;
import com.cenerino.algorithms.java.collections.FibonacciHeap.FibonacciHeapNode;

import java.util.*;

import static java.lang.Double.POSITIVE_INFINITY;
import static java.util.Collections.emptyList;

public class DijkstraShortestPath<V> {

    private final WeightedDirectedGraph<V> graph;
    private final Map<V, WeightedDirectedEdge<V>> edgeTo = new HashMap<>();
    private final Map<V, Double> distanceTo = new HashMap<>();
    private final FibonacciHeap<V> fibHeap = new FibonacciHeap<>();
    private final Map<V, FibonacciHeapNode<V>> seenVertices = new HashMap<>();

    public static <V> DijkstraShortestPath<V> from(WeightedDirectedGraph<V> graph, V source) {
        return new DijkstraShortestPath<>(graph, source);
    }

    private DijkstraShortestPath(WeightedDirectedGraph<V> graph, V source) {
        this.graph = graph;
        assertVertexExist(source);

        FibonacciHeapNode<V> fibHeapNode = new FibonacciHeapNode<>(source);
        fibHeap.insert(fibHeapNode, 0.0);
        seenVertices.put(source, fibHeapNode);
        distanceTo.put(source, 0.0);

        while (!fibHeap.isEmpty())
            graph.adj(fibHeap.removeMin().getData()).stream().forEach(this::relax);
    }

    private void relax(WeightedDirectedEdge<V> edge) {
        V from = edge.from();
        V to = edge.to();

        if (distanceTo.getOrDefault(to, POSITIVE_INFINITY) >
                distanceTo.getOrDefault(from, POSITIVE_INFINITY) + edge.weight()) {
            double distance2To = distanceTo.get(from) + edge.weight();
            distanceTo.put(to, distance2To);
            edgeTo.put(to, edge);

            if (seenVertices.containsKey(to)) fibHeap.decreaseKey(seenVertices.get(to), distance2To);
            else fibHeap.insert(new FibonacciHeapNode<>(to), distance2To);
        }
    }

    public double distanceTo(V v) {
        assertVertexExist(v);
        return distanceTo.getOrDefault(v, POSITIVE_INFINITY);
    }

    public boolean hasPathTo(V v) {
        return distanceTo(v) < POSITIVE_INFINITY;
    }

    public Iterable<WeightedDirectedEdge> pathTo(V target) {
        assertVertexExist(target);
        if (!hasPathTo(target)) return emptyList();

        Deque<WeightedDirectedEdge> path = new LinkedList<>();

        for (WeightedDirectedEdge e = edgeTo.get(target); e != null; e = edgeTo.get(e.from()))
            path.push(e);

        return path;
    }

    private void assertVertexExist(V v) {
        if (!graph.vertices().contains(v)) throw new IllegalArgumentException("vertex not in the graph");
    }
}
