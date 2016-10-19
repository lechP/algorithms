package edu.algs.chap2.sort;

public class ShellUpgradedTest extends AbstractSortingTest {

    @Override
    protected AbstractSort getSut() {
        return new ShellUpgraded();
    }
}