package edu.algs.chap2.sort;

public class InsertionWithSentinelAndHalfExchangesTest extends AbstractSortingTest{

    @Override
    protected AbstractSort getSut() {
        return new InsertionWithSentinelAndHalfExchanges();
    }
}