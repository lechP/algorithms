package edu.algs.chap2.sort;

import edu.algs.chap2.sort.stat.Statistician;

/**
 * Implementation of merge sort with top-down approach
 */
public class MergeBottomUp extends BaseMerge {

    public MergeBottomUp(Statistician stat) {
        super(stat);
    }

    public MergeBottomUp() {

    }

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        temp = new Comparable[N];
        for (int rangeLength = 1; rangeLength < N; rangeLength *= 2)
            for (int low = 0; low < N - rangeLength; low += 2 * rangeLength)
                merge(a, low, low + rangeLength - 1, Math.min(low + 2 * rangeLength - 1, N - 1));
    }

}
