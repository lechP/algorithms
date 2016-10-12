package edu.algs.chap1.p5.uf;

public class QuickUnionUFTest extends AbstractUnionFindTest {

    @Override
    protected UnionFind getSutInstance(int n) {
        return new QuickUnionUF(n);
    }

}