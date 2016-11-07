package edu.algs.chap2.sort.merge;

import edu.algs.chap2.sort.AbstractSortingTest;
import edu.algs.chap2.sort.Sort;

public class MergeTopDownTest extends AbstractSortingTest {

    @Override
    protected Sort getSut() {
        return new MergeTopDown();
    }
}