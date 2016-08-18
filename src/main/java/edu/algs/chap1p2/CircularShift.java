package edu.algs.chap1p2;

import edu.princeton.cs.algs4.StdOut;

/**
 * 1.2.6
 * A string S is a circular shift (or circular rotation) of a string T
 * if it matches when the characters are circularly shifted by any number of positions;
 * e.g., ACTGACG is a circular shift of TGACGAC, and vice versa.
 * Detecting this condition is important in the study of genomic sequences.
 * Write a program that checks whether two given strings s and t are circular shifts of one another.
 * Hint : The solution is a one-liner with indexOf(), length(), and string concatenation.
 */
public class CircularShift {

    public static void main(String[] args) {
        checkCircularity("afasdfas", "fasafasd");
        checkCircularity("aaaaa", "aaaaa");
        checkCircularity("aaaaba", "aaaaab");
        checkCircularity("baaaaa", "aaaaab");
        checkCircularity("aaaaab", "baaaaa");
        checkCircularity("aaaaab", "aaaaab");
        checkCircularity("aaaaba", "aaaaac");
        checkCircularity("", "");
        checkCircularity("x", "x");
    }

    private static void checkCircularity(String x, String y) {
        StdOut.println("Are '" + x + "' and '" + y + "' circular shifts? " + areCircularShifts(x, y));
    }

    private static boolean areCircularShifts(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            s = s.substring(s.length() - 1) + s.substring(0, s.length() - 1);
            if (s.equals(t)) return true;
        }
        return false;
    }

}
