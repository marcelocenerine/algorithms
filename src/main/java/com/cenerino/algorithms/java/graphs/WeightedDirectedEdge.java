package com.cenerino.algorithms.java.graphs;

public class WeightedDirectedEdge<T> implements Comparable<WeightedDirectedEdge<T>> {

    private T from, to;
    private double weight;

    public WeightedDirectedEdge(T from, T to, double weight) {
        if (weight < 0) throw new IllegalArgumentException();

        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public T from() {
        return from;
    }

    public T to() {
        return to;
    }

    public double weight() {
        return weight;
    }

    @Override
    public int compareTo(WeightedDirectedEdge<T> that) {
        return Double.compare(this.weight, that.weight);
    }
}
