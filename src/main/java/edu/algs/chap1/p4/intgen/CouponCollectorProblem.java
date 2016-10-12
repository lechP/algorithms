package edu.algs.chap1.p4.intgen;

import edu.algs.chap1.util.Problem;
import edu.princeton.cs.algs4.StdRandom;

import java.util.HashSet;
import java.util.Set;

/**
 * 1.4.45  Coupon collector problem. Generating random integers as in the 1.4.44 exercise,
 * run experiments to validate the hypothesis that the number of integers generated before all possible values are generated is ~N*H_N.
 */
class CouponCollectorProblem implements Problem {

    @Override
    public double getExpectedValue(int N) {
        double h = 0;
        for (int i = 1; i <= N; i++) {
            h += 1.0 / i;
        }
        return N * h;
    }

    @Override
    public double estimateValue(int N, int repeats) {
        double trialsSum = 0;
        for (int j = 0; j < repeats; j++) {
            trialsSum += countTrialsTillAllAreGenerated(N);
        }
        return trialsSum / repeats;
    }

    private int countTrialsTillAllAreGenerated(int N) {
        Set<Integer> alreadyGenerated = new HashSet<>();
        int counter = 1;
        int val = StdRandom.uniform(N);
        while (alreadyGenerated.size() != N) {
            alreadyGenerated.add(val);
            val = StdRandom.uniform(N);
            counter++;
        }
        return counter;
    }

}
