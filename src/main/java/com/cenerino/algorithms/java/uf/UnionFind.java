package com.cenerino.algorithms.java.uf;

public interface UnionFind {

    boolean isConnected(int p, int q);
    void union(int p, int q);
}
