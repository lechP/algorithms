package edu.algs.chap2.sort;

/**
 * Implementation of selection sort
 */
public class Selection extends AbstractSort {

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int minId = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[minId])) minId = j;
            }
            swap(a, i, minId);
        }
    }
}
