package com.cenerino.algorithms.java.uf;

/**
 * Algorithm analysis:
 *
 * Initialization: N
 * Union: N
 * Connected: N
 */
public class QuickUnion implements UnionFind {

    private int[] ids;

    public QuickUnion(int n) {
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
        return n == ids[n] ? n : root(ids[n]);
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
