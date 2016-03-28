package com.cenerino.algorithms.java.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class KosarajuSharirSCC<V> {

    private Set<V> visited;
    private Map<V, Integer> ids;
    private int[] size;
    private int count;

    private KosarajuSharirSCC(Digraph<V> digraph) {
        ids = new HashMap<>(digraph.vertexCount());
        visited = new HashSet<>(digraph.vertexCount());
        size = new int[digraph.vertexCount()];

        DepthFirstOrder<V> dfo = DepthFirstOrder.from(digraph.reverse());

        for (V vertex : dfo.reversePost()) {
            if (!visited.contains(vertex)) {
                dfs(digraph, vertex);
                count++;
            }
        }
    }

    public static <V> KosarajuSharirSCC<V> from(Digraph<V> digraph) {
        return new KosarajuSharirSCC<>(digraph);
    }

    private void dfs(Graph<V> graph, V vertex) {
        visited.add(vertex);
        ids.put(vertex, count);
        size[count]++;

        for (V adj : graph.adj(vertex))
            if (!visited.contains(adj)) dfs(graph, adj);
    }

    public int size(V vertex) {
        validateVertex(vertex);
        return size[ids.get(vertex)];
    }

    public int count() {
        return count;
    }

    public boolean stronglyConnected(V v1, V v2) {
        validateVertex(v1);
        validateVertex(v2);

        return ids.get(v1).equals(ids.get(v2));
    }

    private void validateVertex(V vertex) {
        if (!ids.containsKey(vertex))
            throw new IllegalArgumentException("vertex " + vertex + " not in the graph");
    }
}
