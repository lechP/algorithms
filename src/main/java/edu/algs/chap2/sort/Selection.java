package edu.algs.chap2.sort;

import edu.algs.chap2.sort.stat.Statistician;

/**
 * Implementation of selection sort
 */
public class Selection extends AbstractSort {

    public Selection(){
        super();
    }

    public Selection(Statistician stat){
        super(stat);
    }

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
