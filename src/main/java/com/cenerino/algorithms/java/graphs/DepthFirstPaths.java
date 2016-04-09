package com.cenerino.algorithms.java.graphs;

import java.util.*;

import static java.util.Collections.emptyList;

public class DepthFirstPaths<V> {

    private Set<V> visited = new HashSet<>();
    private Map<V, V> edgeTo = new HashMap<>();
    private V source;

    private DepthFirstPaths(Graph<V> graph, V source) {
        this.source = source;
        dfs(graph, source);
    }

    public static <V> DepthFirstPaths<V> from(Graph<V> graph, V source) {
        return new DepthFirstPaths<>(graph, source);
    }

    private void dfs(Graph<V> graph, V source) {
        visited.add(source);
        graph.adj(source).stream().forEach(adj -> {
            if (!visited.contains(adj)) {
                edgeTo.put(adj, source);
                dfs(graph, adj);
            }
        });
    }

    public boolean hasPathTo(V target) {
        return visited.contains(target);
    }

    public Iterable<V> pathTo(V target) {
        if (!hasPathTo(target)) return emptyList();

        Deque<V> path = new LinkedList<>();

        for (V v = target; v != source; v = edgeTo.get(v)) {
            path.push(v);
        }

        path.push(source);
        return path;
    }
}
