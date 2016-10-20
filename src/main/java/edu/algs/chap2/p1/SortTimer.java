package edu.algs.chap2.p1;

import edu.algs.chap2.sort.*;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Class designed to measure time of running various sorting algorithms
 */
class SortTimer {

    /**
     * Measures time of sorting with various algs
     *
     * @param alg name of the algorithm
     * @param N   size of the array to be sorted
     * @param T   number of repeats
     * @return average time (in nanoseconds) of sorting array of given size with given algorithm
     */
    static double timeRandomInput(SortAlg alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++) {
                a[i] = StdRandom.uniform();
            }
            total += time(alg, a);
        }
        return total / T;
    }

    private static double time(SortAlg alg, Double[] a) {
        long t0 = System.nanoTime();
        switch (alg) {
            case INSERTION:
                new Insertion().sort(a);
                break;
            case INSERTION_UPGRADED:
                new InsertionWithSentinelAndHalfExchanges().sort(a);
                break;
            case SHELL:
                new Shell().sort(a);
                break;
            case SHELL_UPGRADED:
                new ShellUpgraded().sort(a);
                break;
            case SELECTION:
                new Selection().sort(a);
                break;
            default:
                throw new IllegalArgumentException(String.format("algorithm %s not supported", alg));
        }
        return System.nanoTime() - t0;
    }

}
