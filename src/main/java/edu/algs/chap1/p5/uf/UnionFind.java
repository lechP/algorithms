package edu.algs.chap1.p5.uf;

/**
 * Interface describing Union-find API
 */
interface UnionFind {

    /** adds connection between p and q */
    void union(int p, int q);

    /** returns component identifier for p */
    int find(int p);

    /** returns true if p and q are in the same component */
    boolean connected(int p, int q);

    /** returns number of components */
    int count();

}
