package com.cenerino.algorithms.search;

import java.util.Arrays;

public class QuickUnionWithPathCompression {

    private int[] ids;

    public QuickUnionWithPathCompression(int n) {
        ids = new int[n];

        for (int x = 0; x < n; x++) {
            ids[x] = x;
        }
    }

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

//        while (n != ids[n]) {
//            ids[n] = ids[ids[n]];
//            n = ids[n];
//        }
//
//        return n;
    }

    public void union(int p, int q) {
        int proot = root(p);
        int qroot = root(q);

        if (proot != qroot) {
            ids[proot] = qroot;
        }
    }
}
