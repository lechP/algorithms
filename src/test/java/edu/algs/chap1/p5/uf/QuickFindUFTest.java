package edu.algs.chap1.p5.uf;

public class QuickFindUFTest extends AbstractUnionFindTest {

    protected UnionFind getSutInstance(int n) {
        return new QuickFindUF(n);
    }

}