package com.cenerino.algorithms.java.unionfind;

public interface UnionFind {

    boolean isConnected(int p, int q);
    void union(int p, int q);
}
