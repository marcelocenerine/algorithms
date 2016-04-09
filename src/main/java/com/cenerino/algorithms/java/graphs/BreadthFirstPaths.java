package com.cenerino.algorithms.java.graphs;

import java.util.*;

import static java.util.Collections.emptyList;

public class BreadthFirstPaths<V> {

    private Set<V> visited = new HashSet<>();
    private Map<V, V> edgeTo = new HashMap<>();
    private V source;

    private BreadthFirstPaths(Graph<V> graph, V source) {
        this.source = source;
        bfs(graph, source);
    }

    public static <V> BreadthFirstPaths<V> from(Graph<V> graph, V source) {
        return new BreadthFirstPaths<>(graph, source);
    }

    private void bfs(Graph<V> graph, V source) {
        Queue<V> queue = new LinkedList<>();
        queue.add(source);
        visited.add(source);

        while (!queue.isEmpty()) {
            V vertex = queue.remove();

            graph.adj(vertex).stream().forEach(adj -> {
                if (!visited.contains(adj)) {
                    queue.add(adj);
                    visited.add(adj);
                    edgeTo.put(adj, vertex);
                }
            });
        }
    }

    public boolean hasPathTo(V target) {
        return visited.contains(target);
    }

    public Iterable<V> pathTo(V target) {
        if (!hasPathTo(target)) return emptyList();

        Deque<V> path = new LinkedList<>();

        for (V v = target; v != source; v = edgeTo.get(v)) path.push(v);

        path.push(source);
        return path;
    }
}
