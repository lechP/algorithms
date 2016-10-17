package edu.algs.chap2.sort;

import edu.algs.chap2.sort.stat.Statistician;

/**
 * Implementation of insertion sort
 */
public class Insertion extends AbstractSort {

    public Insertion(){
        super();
    }

    public Insertion(Statistician stat){
        super(stat);
    }

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                swap(a, j, j - 1);
            }
        }
    }
}
