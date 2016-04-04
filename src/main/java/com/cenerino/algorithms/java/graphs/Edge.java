package com.cenerino.algorithms.java.graphs;

public class Edge<T> implements Comparable<Edge<T>> {

    private T v, w;
    private double weight;

    public Edge(T v, T w, double weight) {
        if (weight < 0) throw new IllegalArgumentException();

        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public T either() {
        return v;
    }

    public T other(T vertex) {
        if (vertex.equals(v)) return w;
        return v;
    }

    public double weight() {
        return weight;
    }

    @Override
    public int compareTo(Edge<T> that) {
        return Double.compare(this.weight, that.weight);
    }
}
