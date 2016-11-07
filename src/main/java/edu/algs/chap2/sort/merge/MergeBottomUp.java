package edu.algs.chap2.sort.merge;

import edu.algs.chap2.sort.Sort;

/**
 * Implementation of merge sort with top-down approach
 */
public class MergeBottomUp implements Sort {

    private Merger merger;

    public MergeBottomUp() {
        merger = new DefaultMerger();
    }

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        for (int rangeLength = 1; rangeLength < N; rangeLength *= 2)
            for (int low = 0; low < N - rangeLength; low += 2 * rangeLength)
                merger.merge(a, low, low + rangeLength - 1, Math.min(low + 2 * rangeLength - 1, N - 1));
    }

}
