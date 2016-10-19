package edu.algs.chap2.sort;

import edu.algs.chap2.sort.stat.Statistician;

/**
 * Implementation of insertion sort
 */
public class ShellUpgraded extends AbstractSort {

    private final int[] hSequence = {1, 5, 19, 41, 109, 209, 505, 929, 2161, 3905, 8929, 16001, 36289, 64769, 146305, 260609};

    public ShellUpgraded(Statistician stat) {
        super(stat);
    }

    public ShellUpgraded() {

    }

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        int hId = hSequence.length - 1;
        while (hSequence[hId] > N) hId--;
        while (hId >= 0) {
            int h = hSequence[hId];
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    swap(a, j, j - h);
                }
            }
            hId--;
        }
    }
}
