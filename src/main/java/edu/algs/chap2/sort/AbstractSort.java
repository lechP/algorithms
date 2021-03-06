package edu.algs.chap2.sort;

import edu.algs.chap2.sort.stat.QuietConsoleStatistician;
import edu.algs.chap2.sort.stat.Statistician;

/**
 * Abstract class for sorting having two building blocks of sorting operation:
 * swap - for swapping two elements of the array
 * less - for comparing two elements
 *
 * It has also component Statistician for further analyses.
 */
public abstract class AbstractSort implements Sort{

    private Statistician stat;

    public AbstractSort(){
        stat = new QuietConsoleStatistician();
    }

    public AbstractSort(Statistician stat){
        this.stat = stat;
    }

    public Statistician getStat(){
        return stat;
    }

    public void analyzeSort(Comparable[] a){
        stat.setN(a.length);
        stat.setAlgName(this.getClass().getSimpleName());
        sort(a);
    }

    public abstract void sort(Comparable[] a);

    /**
     * Checks if the array is sorted
     * @param a the array of comparables
     * @return true if sorted, false otherwise
     */
    public boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) return false;

        }
        return true;
    }

    /**
     * Swaps two elements of the array
     *
     * @param a array
     * @param i index of first element
     * @param j index of second element
     */
    protected void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        stat.notifySwap(a, i, j);
    }

    public boolean less(Comparable left, Comparable right) {
        stat.notifyCompare(left, right);
        //noinspection unchecked
        return left.compareTo(right) < 0;
    }

}
