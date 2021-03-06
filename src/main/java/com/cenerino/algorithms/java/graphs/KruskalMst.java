package com.cenerino.algorithms.java.graphs;

import com.cenerino.algorithms.java.uf.QuickUnionWithPathCompression;
import com.cenerino.algorithms.java.uf.UnionFind;

import java.util.*;

public class KruskalMst<V> {

    private final Queue<WeightedUndirectedEdge<V>> mst = new LinkedList<>();
    private double weight;

    public static <V> KruskalMst<V> from(WeightedUndirectedGraph<V> graph) {
        return new KruskalMst<>(graph);
    }

    private KruskalMst(WeightedUndirectedGraph<V> graph) {
        Queue<WeightedUndirectedEdge<V>> queue = new PriorityQueue<>(graph.edges());
        UnionFind uf = new QuickUnionWithPathCompression(graph.vertexCount());
        Map<V, Integer> mapVxToId = new HashMap<>(); // TODO make UF generic?
        int i = 0;
        for (V v : graph.vertices()) mapVxToId.put(v, i++); // FIXME mapping vertex to id in the union find alg.

        while (!queue.isEmpty() && mst.size() < graph.vertexCount() - 1) {
            WeightedUndirectedEdge<V> undirectedEdge = queue.remove();
            V v = undirectedEdge.either();
            V w = undirectedEdge.other(v);
            int vid = mapVxToId.get(v);
            int wid = mapVxToId.get(w);

            if (!uf.isConnected(vid, wid)) {
                uf.union(vid, wid);
                mst.add(undirectedEdge);
                weight += undirectedEdge.weight();
            }
        }
    }

    public Collection<WeightedUndirectedEdge<V>> edges() {
        return Collections.unmodifiableCollection(mst);
    }

    public double weight() {
        return weight;
    }
}