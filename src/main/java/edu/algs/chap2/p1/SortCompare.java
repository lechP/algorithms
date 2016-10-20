package edu.algs.chap2.p1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static edu.algs.chap2.p1.SortAlg.*;
import static edu.algs.chap2.p1.SortTimer.timeRandomInput;

/**
 * Class comparing time of running sorting algorithms
 * <p>
 * Used for various excercises
 */
public class SortCompare {

    private final static Logger LOG = LoggerFactory.getLogger(SortCompare.class);

    public static void main(String[] args) {

        //exc2_1_24_and_25();
//        checkShellSubquadraticHypothesis();
        compareShellsortUpgradeToShellsort();
    }


    /**
     * exc 2.1.29
     */
    private static void compareShellsortUpgradeToShellsort() {
        SortAlg baseShell = SHELL;
        SortAlg upgradedShell = SHELL_UPGRADED;
        int T = 10;
        int[] Ns = {100, 1000, 10_000, 50_000, 100_000, 1_000_000};

        for (int N : Ns) {
            double tBase = timeRandomInput(baseShell, N, T);
            double tUpgraded = timeRandomInput(upgradedShell, N, T);

            LOG.info(algStat(baseShell, tBase, N));
            LOG.info(algStat(upgradedShell, tUpgraded, N));
            LOG.info(String.format("%s/%s times ratio: %.2f", upgradedShell, baseShell, tUpgraded / tBase * 100) + "%");
        }

    }

    /**
     * exc 2.1.27
     */
    private static void checkShellSubquadraticHypothesis() {
        int T = 10;
        int[] Ns = new int[12]; //2^(11+7) ~= 262k -> insertion runs about 1h (and 10h for T=10)
        for (int i = 0; i < Ns.length; i++) {
            Ns[i] = (int) Math.pow(2, 7 + i);
        }
        SortAlg shell = SHELL;
        SortAlg insertion = INSERTION;
        SortAlg selection = SELECTION;
        for (int N : Ns) {
            double tShell = timeRandomInput(shell, N, T);
            double tInsert = timeRandomInput(insertion, N, T);
            double tSelect = timeRandomInput(selection, N, T);

            LOG.info(algStat(shell, tShell, N));
            LOG.info(algStat(insertion, tInsert, N));
            LOG.info(algStat(selection, tSelect, N));
        }
    }

    private static void exc2_1_24_and_25() {
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
        SortAlg alg1 = INSERTION_UPGRADED;
        SortAlg alg2 = INSERTION;

        double t1 = timeRandomInput(alg1, n, t);
        double t2 = timeRandomInput(alg2, n, t);

        LOG.info(algStat(alg1, t1, n));
        LOG.info(algStat(alg2, t2, n));
        LOG.info(String.format("%s/%s times ratio: %.2f", alg2, alg1, t2 / t1 * 100) + "%");
    }

    private static String algStat(SortAlg alg, double t, int n) {
        return String.format("%s for N=%d needs avg. %.3f seconds", alg, n, t / Math.pow(10, 9));
    }

}
