package edu.algs.chap1.p5.uf.compare;

import edu.algs.chap1.p5.uf.PathCompressingWeightedQuickUnionUF;
import edu.algs.chap1.p5.uf.UnionFind;
import edu.algs.chap1.p5.uf.WeightedQuickUnionUF;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This class is intended to compare the performance of two fastest UF implementations:
 * - WeightedQuickUnionFind
 * - PathCompressingWeightedQuickUnionFind
 * on very large set of data
 *
 * Result:
 * with N = 10M and 20M randomly generated edges path compression allows to save about 20% of the time
 */
public class FastestUnionFindComparator {

    private static int n;

    public static void main(String[] args) {

        n = 10_000_000;
        FastestUnionFindComparator comparator = new FastestUnionFindComparator();
        Pair[] pairs = comparator.generatePairs();

        comparator.analyze(pairs, new PathCompressingWeightedQuickUnionUF(n));
        comparator.analyze(pairs, new WeightedQuickUnionUF(n));
    }

    private Pair[] generatePairs() {
        System.out.println("Pairs generation started");
        int limit = 2 * n;
        Pair[] result = new Pair[limit];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            int q_i = r.nextInt(n - i) + i;
            result[2 * i] = new Pair(i, q_i);
            int j = n - i;
            int q_j = r.nextInt(j);
            result[2 * i + 1] = new Pair(j - 1, q_j);
            if (i % 1_000_000 == 0) System.out.println(i);
        }
        System.out.println("Pairs generation completed. Shuffling...");
        shuffleArray(result);
        System.out.println("Shuffling completed.");
        return result;
    }

    // Implementing Fisher–Yates shuffle
    private void shuffleArray(Pair[] ar) {
        // If running on Java 6 or older, use `new Random()` on RHS here
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            Pair a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    private void analyze(Pair[] pairs, UnionFind algorithm) {
        long time = performConnection(pairs, algorithm);
        System.out.println(time + " nanosecs | " + time * 1.0 / 1_000_000_000 + " secs for algorithm: " + algorithm.getClass().getSimpleName());
    }

    private long performConnection(Pair[] input, UnionFind algorithm) {
        long startTime = System.nanoTime();
        int count = 0;
        for (Pair pair : input) {
            algorithm.union(pair.p, pair.q);
            count++;
            if (count % 1_000_000 == 0) System.out.println("Progress: " + count + "/" + input.length);
        }
        return System.nanoTime() - startTime;
    }

    private class Pair {
        int p;
        int q;

        Pair(int p, int q) {
            this.p = p;
            this.q = q;
        }
    }

    private class UFInput {
        int n;
        List<Pair> pairs;

        UFInput(int n) {
            this.n = n;
            this.pairs = new ArrayList<>(n);
        }
    }


}
