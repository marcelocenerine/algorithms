package com.cenerino.algorithms.java.graphs;

import com.cenerino.algorithms.java.unionfind.QuickUnionWithPathCompression;
import com.cenerino.algorithms.java.unionfind.UnionFind;

import java.util.*;

public class KruskalMst<V> {

    private final Queue<Edge<V>> mst = new LinkedList<>();
    private double weight;

    public static <V> KruskalMst<V> from(UndirectedWeightedGraph<V> graph) {
        return new KruskalMst<>(graph);
    }

    private KruskalMst(UndirectedWeightedGraph<V> graph) {
        Queue<Edge<V>> queue = new PriorityQueue<>(graph.edges());
        UnionFind uf = new QuickUnionWithPathCompression(graph.vertexCount());
        Map<V, Integer> mapVxToId = new HashMap<>(); // TODO make UF generic?
        int i = 0;
        for (V v : graph.vertices()) mapVxToId.put(v, i++); // FIXME mapping vertex to id in the union find alg.

        while (!queue.isEmpty() && mst.size() < graph.vertexCount() - 1) {
            Edge<V> edge = queue.remove();
            V v = edge.either();
            V w = edge.other(v);
            int vid = mapVxToId.get(v);
            int wid = mapVxToId.get(w);

            if (!uf.isConnected(vid, wid)) {
                uf.union(vid, wid);
                mst.add(edge);
                weight += edge.weight();
            }
        }
    }

    public Collection<Edge<V>> edges() {
        return Collections.unmodifiableCollection(mst);
    }

    public double weight() {
        return weight;
    }
}