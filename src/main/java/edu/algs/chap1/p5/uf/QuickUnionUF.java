package edu.algs.chap1.p5.uf;

/**
 * 1.5.7
 * Implementation of Union Find which in comparison to QuickFind
 * concentrates on speeding up the union() operation.
 * It is based on the same data structure—the site-indexed id[] array
 * but we interpret the values differently, to define more complicated structures.
 * Specifically, the id[] entry for each site is the name of another site in the same component
 * (possibly itself)—we refer to this connection as a link.
 */
class QuickUnionUF extends AbstractUnionFind {

    QuickUnionUF(int N) {
        super(N);
    }

    @Override
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        id[i] = j;
        count--;
    }

    @Override
    public int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

}
