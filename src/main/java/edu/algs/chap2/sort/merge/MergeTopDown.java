package edu.algs.chap2.sort.merge;

import edu.algs.chap2.sort.Sort;

/**
 * Implementation of merge sort with top-down approach
 */
public class MergeTopDown implements Sort {

    private Merger merger;

    public MergeTopDown() {
        merger = new DefaultMerger();
    }

    public MergeTopDown(Merger merger){
        this.merger = merger;
    }

    @Override
    public void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int low, int high) {
        if (high <= low) return;
        int mid = (low + high) / 2;
        sort(a, low, mid);
        sort(a, mid + 1, high);
        merger.merge(a, low, mid, high);
    }

}
