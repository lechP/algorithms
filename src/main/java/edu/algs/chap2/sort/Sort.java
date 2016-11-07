package edu.algs.chap2.sort;

public interface Sort {

    void sort(Comparable[] a);

    /**
     * Checks if the array is sorted
     *
     * @param a the array of comparables
     * @return true if sorted, false otherwise
     */
    default boolean isSorted(Comparable[] a) {

        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) return false;
        }
        return true;
    }

    /**
     * Compares two items and returns true if left item is less than right, false otherwise
     *
     * @param left  left item
     * @param right right item
     */
    default boolean less(Comparable left, Comparable right) {
        //noinspection unchecked
        return left.compareTo(right) < 0;
    }
}
