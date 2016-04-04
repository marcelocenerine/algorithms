package com.cenerino.algorithms.java.graphs;

public class DirectedGraph<V> extends AbstractGraph<V> implements Digraph<V> {

    @Override
    public void addEdge(V source, V target) {
        validateVertices(source, target);
        adjacencyLists.get(source).add(target);
        edgeCount++;
    }

    @Override
    public Digraph<V> reverse() {
        Digraph<V> rev = new DirectedGraph<>();

        for (V vertex : vertices())
            rev.addVertex(vertex);

        for (V vertex : vertices())
            for (V adj : adj(vertex))
                rev.addEdge(adj, vertex);

        return rev;
    }
}
