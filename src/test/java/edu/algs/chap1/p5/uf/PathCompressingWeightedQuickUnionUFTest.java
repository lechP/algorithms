package edu.algs.chap1.p5.uf;

public class PathCompressingWeightedQuickUnionUFTest extends AbstractUnionFindTest {

    @Override
    protected UnionFind getSutInstance(int n) {
        return new PathCompressingWeightedQuickUnionUF(n);
    }

}