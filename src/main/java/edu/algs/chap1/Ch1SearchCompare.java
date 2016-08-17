package edu.algs.chap1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * 1.1.38
 * Binary search versus brute-force search.
 * Write a program BruteForceSearch that uses the brute-force search method given on page 48
 * and compare its running time on your computer with that of BinarySearch for largeW.txt and largeT.txt.
 */
public class Ch1SearchCompare {

    public static void main(String[] args) {
        compareSearchesFor("/algs4-data/largeW.txt", 536107);
        compareSearchesFor("/algs4-data/largeT.txt", 606630);
    }

    private static void compareSearchesFor(String inputName, int key) {
        int[] input = new In(inputName).readAllInts();
        long t0 = System.nanoTime();
        Arrays.sort(input);
        //In inputT = new In("/largeT.txt");
        long t1 = System.nanoTime();
        bruteForceSearch(key, input);
        long t2 = System.nanoTime();
        binarySearch(key, input);
        long t3 = System.nanoTime();

        StdOut.println("Sorting took: " + (t1 - t0) * 1.0 / 1000000 + "ms");
        StdOut.println("Brute force took: " + (t2 - t1) * 1.0 / 1000000 + "ms");
        StdOut.println("Binary search took: " + (t3 - t2) * 1.0 / 1000000 + "ms");
    }

    private static int bruteForceSearch(int key, int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) {
                return i;
            }
        }
        return -1;
    }

    private static int binarySearch(int key, int[] a) {
        //Array must be sorted.
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {  // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }


}

