package com.cenerino.algorithms.java.graphs;

import java.util.*;

public class ConnectedComponents<V> {

    private Set<V> visited;
    private Map<V, Integer> ids;
    private int[] size;
    private int count;

    private ConnectedComponents(Graph<V> graph) {
        ids = new HashMap<>(graph.vertexCount());
        visited = new HashSet<>(graph.vertexCount());
        size = new int[graph.vertexCount()];

        for (V vertex : graph.vertices()) {
            if (!visited.contains(vertex)) {
                dfs(graph, vertex);
                count++;
            }
        }
    }

    public static <V> ConnectedComponents<V> from(Graph<V> graph) {
        return new ConnectedComponents<>(graph);
    }

    private void dfs(Graph<V> graph, V vertex) {
        visited.add(vertex);
        ids.put(vertex, count);
        size[count]++;

        for (V adj : graph.adj(vertex)) {
            if (!visited.contains(adj)) {
                dfs(graph, adj);
            }
        }
    }

    public int size(V vertex) {
        validateVertex(vertex);
        return size[ids.get(vertex)];
    }

    public int count() {
        return count;
    }

    public boolean connected(V v1, V v2) {
        validateVertex(v1);
        validateVertex(v2);

        return ids.get(v1).equals(ids.get(v2));
    }

    private void validateVertex(V vertex) {
        if (!ids.containsKey(vertex))
            throw new IllegalArgumentException("vertex " + vertex + " not in the graph");
    }
}
