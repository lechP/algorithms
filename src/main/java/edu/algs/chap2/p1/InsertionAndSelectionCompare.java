package edu.algs.chap2.p1;

import edu.algs.chap2.sort.Insertion;
import edu.algs.chap2.sort.Selection;

/**
 * 2.1.6 & 2.1.7
 */

public class InsertionAndSelectionCompare {

    public static void main(String[] args) {
        compareForIdenticalKeys();
        compareForReverseArrays();
    }

    /**
     * 2.1.6 Which method runs faster for an array with all keys identical, selection sort or insertion sort?
     * Selection needs always N(N-1)/2 compares and N swaps
     * Insertion needs here N-1 compares and 0 swaps
     */
    private static void compareForIdenticalKeys() {
        Integer[] identical = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        Insertion insertion = new Insertion();
        insertion.analyzeSort(identical);
        insertion.getStat().printReport();

        Selection selection = new Selection();
        selection.analyzeSort(identical);
        selection.getStat().printReport();
    }

    /**
     * 2.1.7 Which method runs faster for an array in reverse order, selection sort or insertion sort?
     * Selection needs always N(N-1)/2 compares and N swaps
     * Insertion needs here N(N-1)/2 both compares and swaps
     */
    private static void compareForReverseArrays() {
        Integer[] reverse1 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        Integer[] reverse2 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        Insertion insertion = new Insertion();
        insertion.analyzeSort(reverse1);
        insertion.getStat().printReport();

        Selection selection = new Selection();
        selection.analyzeSort(reverse2);
        selection.getStat().printReport();
    }

}
