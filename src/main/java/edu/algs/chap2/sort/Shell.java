package edu.algs.chap2.sort;

import edu.algs.chap2.sort.stat.Statistician;

/**
 * Implementation of insertion sort
 */
public class Shell extends AbstractSort {

    public Shell(Statistician stat) {
        super(stat);
    }

    public Shell() {

    }

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    swap(a, j, j - h);
                }
            }
            h /= 3;
        }
    }
}
