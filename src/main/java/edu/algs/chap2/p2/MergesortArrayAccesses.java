package edu.algs.chap2.p2;

import edu.algs.chap2.sort.merge.CountingMerger;
import edu.algs.chap2.sort.merge.MergeBottomUp;
import edu.algs.chap2.sort.merge.MergeTopDown;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 2.2.6
 * Write a program to compute the exact value of the number of array accesses
 * used by top-down mergesort and by bottom-up mergesort.
 * Use your program to plot the values for N from 1 to 512, and to compare the exact values with the upper bound 6N lg N
 */
public class MergesortArrayAccesses {

    public static void main(String[] args) {
        int N = 1024;
        double[] boundVals = new double[N];
        double[] topDownVals = new double[N];
        double[] bottomUpVals = new double[N];
        for (int i = 0; i < N; i++) {
            Comparable[] a = generateArray(i);
            Comparable[] b = new Comparable[i];
            System.arraycopy(a, 0, b, 0, a.length);

            CountingMerger mergerTD = new CountingMerger();
            MergeTopDown mergeTD = new MergeTopDown(mergerTD);
            mergeTD.sort(a);
            topDownVals[i] = mergerTD.getArrayAccessesCount();

            CountingMerger mergerBU = new CountingMerger();
            MergeBottomUp bu = new MergeBottomUp(mergerBU);
            bu.sort(b);
            bottomUpVals[i] = mergerBU.getArrayAccessesCount();

            boundVals[i] = 6 * i * Math.log(i) / Math.log(2);
        }

        for (int i = 0; i < N; i++) {
            StdDraw.setXscale(0, N * 1.05);
            StdDraw.setYscale(0, boundVals[N - 1] * 1.05);
            //System.out.println("i: " + i + "; bound: " + boundVals[i] + "; top-down: " + topDownVals[i] + "; bottom-up: " + bottomUpVals[i]);
            StdDraw.setPenColor(StdDraw.BOOK_RED);
            StdDraw.point(i, boundVals[i]);
            StdDraw.setPenColor(StdDraw.BOOK_BLUE);
            StdDraw.point(i, topDownVals[i]);
            StdDraw.setPenColor(StdDraw.GRAY);
            StdDraw.point(i, bottomUpVals[i]);
        }

    }

    private static Comparable[] generateArray(int n) {
        Comparable[] result = new Comparable[n];
        for (int i = 0; i < n; i++) {
            result[i] = StdRandom.uniform();
        }
        return result;
    }

}
