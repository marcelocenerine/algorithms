package com.cenerino.algorithms.java.graphs;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class DepthFirstOrder<V> {

    private Deque<V> reversePost = new LinkedList<>();
    private Queue<V> visited = new LinkedList<>();

    private DepthFirstOrder(Digraph<V> digraph) {
        for (V vertex : digraph.vertices())
            if (!visited.contains(vertex)) dfs(digraph, vertex);
    }

    public static <V> DepthFirstOrder<V> from(Digraph<V> digraph) {
        return new DepthFirstOrder<>(digraph);
    }

    private void dfs(Digraph<V> digraph, V vertex) {
        visited.add(vertex);

        for (V adj : digraph.adj(vertex))
            if (!visited.contains(adj)) dfs(digraph, adj);

        reversePost.push(vertex);
    }

    public Iterable<V> reversePost() {
        return reversePost;
    }
}
