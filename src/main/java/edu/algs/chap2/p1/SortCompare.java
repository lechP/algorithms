package edu.algs.chap2.p1;

import edu.algs.chap2.sort.Insertion;
import edu.algs.chap2.sort.InsertionWithSentinelAndHalfExchanges;
import edu.algs.chap2.sort.Selection;
import edu.algs.chap2.sort.Shell;
import edu.princeton.cs.algs4.StdRandom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class comparing time of running sorting algorithms
 * <p>
 * Used for excercises 2.1.24 & 2.1.25
 */
public class SortCompare {

    private final static Logger LOG = LoggerFactory.getLogger(SortCompare.class);

    public static void main(String[] args) {

        int T = 10;
        int[] Ns = {100, 1000, 10000, 50000, 100000};
        for (int N : Ns) {
            compareNormalAndUpgradedInsertion(N, T);
        }

    }

    /**
     * excs 2.1.24 & 2.1.25
     * Conclusion: for small N's 'upgrade' is worthless, but for big it goes better
     */
    private static void compareNormalAndUpgradedInsertion(int n, int t) {
        String alg1 = "InsertionWithSentinelAndHalfExchanges";
        String alg2 = "Insertion";

        double t1 = timeRandomInput(alg1, n, t);
        double t2 = timeRandomInput(alg2, n, t);

        LOG.info(algStat(alg1, t1 * 1.0 / t, n));
        LOG.info(algStat(alg2, t2 * 1.0 / t, n));
        LOG.info(String.format("%s/%s times ratio: %.2f", alg2, alg1, t2 / t1 * 100) + "%");
    }

    private static String algStat(String alg, double t, int n) {
        return String.format("%s for N=%d needs avg. %.3f seconds", alg, n, t / Math.pow(10, 9));
    }

    public static double time(String alg, Double[] a) {
        long t0 = System.nanoTime();
        switch (alg) {
            case "Insertion":
                new Insertion().sort(a);
                break;
            case "InsertionWithSentinelAndHalfExchanges":
                new InsertionWithSentinelAndHalfExchanges().sort(a);
                break;
            case "Shell":
                new Shell().sort(a);
                break;
            case "Selection":
                new Selection().sort(a);
                break;
            default:
                break;
        }
        return System.nanoTime() - t0;
    }

    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++) {
                a[i] = StdRandom.uniform();
            }
            total += time(alg, a);
        }
        return total;
    }

}
