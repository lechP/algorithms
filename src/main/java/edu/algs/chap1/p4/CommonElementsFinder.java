package edu.algs.chap1.p4;

import java.util.Set;
import java.util.TreeSet;

/**
 * 1.4.12 Write a program that, given two sorted arrays of N int values,
 * prints all elements that appear in both arrays, in sorted order.
 * The running time of your program should be proportional to N in the worst case.
 */
class CommonElementsFinder {

    Set<Integer> findCommonElements(int[] a, int[] b) {
        int indexA = 0;
        int indexB = 0;
        Set<Integer> result = new TreeSet<>();
        while (indexA < a.length && indexB < b.length) {
            while (indexB < b.length && b[indexB] < a[indexA]) {
                indexB++;
            }
            if (indexB < b.length && b[indexB] == a[indexA]) {
                result.add(b[indexB++]);
            }
            indexA++;
        }
        return result;
    }
}
