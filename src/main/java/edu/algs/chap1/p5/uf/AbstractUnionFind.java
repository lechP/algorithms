package edu.algs.chap1.p5.uf;

abstract class AbstractUnionFind implements UnionFind {

    protected int count;
    int[] id;

    AbstractUnionFind(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int count() {
        return count;
    }
}
