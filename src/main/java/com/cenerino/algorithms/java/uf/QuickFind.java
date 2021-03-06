package com.cenerino.algorithms.java.uf;

/**
 * Algorithm analysis:
 *
 * Initialization: N
 * Union: N
 * Connected: 1
 */
public class QuickFind implements UnionFind {

    private int[] ids;

    public QuickFind(int n) {
        ids = new int[n];

        for (int x = 0; x < n; x++) {
            ids[x] = x;
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        return ids[p] == ids[q];
    }

    @Override
    public void union(int p, int q) {
        if (!isConnected(p,q)) {
            int pid = ids[p];
            int qid = ids[q];

            for (int x = 0; x < ids.length; x++) {
                if (ids[x] == pid) {
                    ids[x] = qid;
                }
            }
        }
    }
}
