package com.cenerino.algorithms.search;

import java.util.Arrays;

/**
 * Algorithm analysis:
 *
 * Initialization: log2(N)
 * Union: log2(N)
 * Connected: log2(N)
 */
public class WeightedQuickUnion {

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

    public boolean isConnected(int p, int q) {
        return root(p) == root(q);
    }

    private int root(int n) {
        return n == ids[n] ? n : root(ids[n]);
    }

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
