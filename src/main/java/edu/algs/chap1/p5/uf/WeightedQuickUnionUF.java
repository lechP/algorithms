package edu.algs.chap1.p5.uf;

/**
 * 1.5.11
 * Implement weighted quick-find, where you always change
 * the id[] entries of the smaller component to the identifier of the larger component.
 * How does this change affect performance?
 */
public class WeightedQuickUnionUF extends AbstractUnionFind {

    public WeightedQuickUnionUF(int N) {
        super(N);
        size = new int[N];
        for (int i = 0; i < size.length; i++) {
            size[i] = 1;
        }
    }

    private int[] size;

    @Override
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        //pin smaller to larger and update size of the larger
        if (size[i] < size[j]) {
            id[i] = j;
            size[j] += size[i];
        } else {
            id[j] = i;
            size[i] += size[j];
        }
        count--;
    }

    @Override
    public int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

}
