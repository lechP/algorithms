package edu.algs.chap1.p5.uf;

public class WeightedQuickUnionUFTest extends AbstractUnionFindTest {

    @Override
    protected UnionFind getSutInstance(int n) {
        return new WeightedQuickUnionUF(n);
    }

}