package com.cenerino.algorithms.java.graphs;

public class WeightedUndirectedEdge<T> implements Comparable<WeightedUndirectedEdge<T>> {

    private T v, w;
    private double weight;

    public WeightedUndirectedEdge(T v, T w, double weight) {
        if (weight < 0) throw new IllegalArgumentException(); // limitation in the current implementation

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
    public int compareTo(WeightedUndirectedEdge<T> that) {
        return Double.compare(this.weight, that.weight);
    }
}
