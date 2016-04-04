package com.cenerino.algorithms.java.unionfind;

public class QuickUnionWithPathCompression implements UnionFind {

    private int[] ids;

    public QuickUnionWithPathCompression(int n) {
        ids = new int[n];

        for (int x = 0; x < n; x++) {
            ids[x] = x;
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        return root(p) == root(q);
    }

    private int root(int n) {
        if (n == ids[n]) return n;

        int root = root(ids[n]);

        if (root != ids[n]) {
            ids[n] = root;
        }

        return root;
    }

    @Override
    public void union(int p, int q) {
        int proot = root(p);
        int qroot = root(q);

        if (proot != qroot) {
            ids[proot] = qroot;
        }
    }
}
