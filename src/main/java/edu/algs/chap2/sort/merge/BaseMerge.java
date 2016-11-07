package edu.algs.chap2.sort.merge;

import edu.algs.chap2.sort.Sort;

public abstract class BaseMerge implements Sort {

    protected Comparable[] temp;

    public BaseMerge() {
    }

    protected void merge(Comparable[] a, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        System.arraycopy(a, low, temp, low, high + 1 - low);

        for (int k = low; k <= high; k++) {
            if (i > mid) {
                a[k] = temp[j++];
            } else if (j > high) {
                a[k] = temp[i++];
            } else if (less(temp[j], temp[i])) {
                a[k] = temp[j++];
            } else {
                a[k] = temp[i++];
            }
        }
    }

}
