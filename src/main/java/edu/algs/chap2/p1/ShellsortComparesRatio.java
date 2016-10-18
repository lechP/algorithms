package edu.algs.chap2.p1;

import edu.algs.chap2.sort.AbstractSort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * 2.1.12
 * Instrument shellsort to print the number of compares divided by the array size for each increment.
 * Write a test client that tests the hypothesis that this number is a small constant,
 * by sorting arrays of random Double values, using array sizes that are increasing powers of 10, starting at 100.
 *
 * Results are extra interesting. Just run and see :) There is really a pattern.
 */
public class ShellsortComparesRatio extends AbstractSort {

    private static final Logger LOG = LoggerFactory.getLogger(ShellsortComparesRatio.class);

    public static void main(String[] args) {
        for (int i = 2; i <= 8; i++) {
            experiment(i);
        }
    }

    private static void experiment(int k) {
        Double[] a = new Double[(int) Math.pow(10, k)];
        Random r = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextDouble();
        }
        ShellsortComparesRatio sort = new ShellsortComparesRatio();
        sort.sort(a);
    }

    private ShellsortComparesRatio() {
        super();
    }

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        long allCompares = 0;
        while (h < N / 3) h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    swap(a, j, j - h);
                }
            }
            allCompares = printComparesRatio(N, h, allCompares);
            h /= 3;
        }
    }

    private long printComparesRatio(int n, int h, long allCompares) {
        long count = getStat().getStats().getCompares();
        long currentCompares = count - allCompares;
        allCompares = count;
        String message = String.format("For n=%d and h=%d ratio 'compares/N' is equal to: %.2f", n, h, currentCompares * 1.0 / n);
        LOG.info(message);
        return allCompares;
    }
}
