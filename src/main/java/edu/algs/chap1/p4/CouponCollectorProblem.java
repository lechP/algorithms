package edu.algs.chap1.p4;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 1.4.45  Coupon collector problem. Generating random integers as in the 1.4.44 exercise,
 * run experiments to validate the hypothesis that the number of integers generated before all possible values are generated is ~N*H_N.
 */
public class CouponCollectorProblem {


    public static void main(String[] args) {
        int limit = 500;
        double[] empiric = new double[limit];
        double[] expected = new double[limit];

        for (int i = 0; i < limit; i++) {
            int N = (i + 1) * 10;
            empiric[i] = estimateValue(N, 100);
            expected[i] = getExpectedValue(N);
        }

        StdDraw.setXscale(0, limit * 10);
        StdDraw.setYscale(0, 1.2 * getExpectedValue(limit * 10));

        StdDraw.setPenColor(Color.RED);
        for (int i = 0; i < limit; i++) {
            new Point2D((i + 1) * 10, empiric[i]).draw();
        }
        StdDraw.setPenColor(Color.BLUE);
        for (int i = 0; i < limit; i++) {
            new Point2D((i + 1) * 10, expected[i]).draw();
        }
    }

    private static double getExpectedValue(int N) {
        double h = 0;
        for (int i = 1; i <= N; i++) {
            h += 1.0 / i;
        }
        return N * h;
    }

    private static double estimateValue(int N, int repeats) {
        double trialsSum = 0;
        for (int j = 0; j < repeats; j++) {
            trialsSum += countTrialsTillAllAreGenerated(N);
        }
        return trialsSum / repeats;
    }

    private static int countTrialsTillAllAreGenerated(int N) {
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
