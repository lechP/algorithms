package edu.algs.chap2.sort;

import edu.algs.chap2.sort.stat.Statistician;

/**
 * Implementation of merge sort with top-down approach
 */
public class MergeTopDown extends BaseMerge {

    public MergeTopDown(Statistician stat) {
        super(stat);
    }

    public MergeTopDown() {
    }

    @Override
    public void sort(Comparable[] a) {
        temp = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int low, int high) {
        if (high <= low) return;
        int mid = (low + high) / 2;
        sort(a, low, mid);
        sort(a, mid + 1, high);
        merge(a, low, mid, high);
    }

}
