package edu.algs.chap2.sort;

/**
 * 2.1.24  Insertion sort with sentinel.
 * Develop an implementation of insertion sort that eliminates the j>0 test
 * in the inner loop by first putting the smallest item into position.
 *
 * 2.1.25  Insertion sort without exchanges.
 * Develop an implementation of insertion sort that moves larger elements
 * to the right one position with one array access per entry, rather than using exch().
 *
 * Use SortCompare to evaluate the effectiveness of doing so.
 */
public class InsertionWithSentinelAndHalfExchanges extends AbstractSort {

    @Override
    public void sort(Comparable[] a) {
        if (placeSentinel(a) == 0) return; //array is sorted
        sortTheRest(a);
    }

    private void sortTheRest(Comparable[] a) {
        for (int i = 2; i < a.length; i++) {
            Comparable v = a[i];
            int j = i;
            while (less(v, a[j - 1])) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = v;
        }
    }

    private int placeSentinel(Comparable[] a) {
        int swaps = 0;
        for (int i = a.length - 1; i > 0; i--) {
            if (less(a[i], a[i - 1])) {
                swap(a, i, i - 1);
                swaps++;
            }
        }
        return swaps;
    }
}
