package edu.algs.chap1.p5.uf;

/**
 * 1.5.7
 * Implementation of Union Find in which we maintain the invariant
 * that p and q are connected if and only if id[p] is equal to id[q].
 * In other words, all sites in a component must have the same value in id[].
 * This method is called quick-find because find(p) just returns id[p],
 * which immediately implies that connected(p, q) reduces to just the test id[p] == id[q]
 * and returns true if and only if p and q are in the same component.
 */
class QuickFindUF extends AbstractUnionFind {

    QuickFindUF(int N) {
        super(N);
    }

    @Override
    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);
        if (pID == qID) return;
        for (int i = 0; i < id.length; i++)
            if (id[i] == pID) id[i] = qID;
        count--;
    }

    @Override
    public int find(int p) {
        return id[p];
    }

}
