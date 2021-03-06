package com.cenerino.algorithms.java.uf;

/**
 * Algorithm analysis:
 *
 * Initialization: log2(N)
 * Union: log2(N)
 * Connected: log2(N)
 */
public class WeightedQuickUnion implements UnionFind {

    private int[] ids;
    private int[] sizes;

    public WeightedQuickUnion(int n) {
        ids = new int[n];
        sizes = new int[n];

        for (int x = 0; x < n; x++) {
            ids[x] = x;
            sizes[x] = 1;
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
            if (sizes[proot] < sizes[qroot]){
                ids[proot] = qroot;
                sizes[qroot] += sizes[proot];
            } else {
                ids[qroot] = proot;
                sizes[proot] += sizes[qroot];
            }
        }
    }
}
