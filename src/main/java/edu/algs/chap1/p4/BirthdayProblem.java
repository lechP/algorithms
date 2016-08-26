package edu.algs.chap1.p4;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 1.4.44  Birthday problem. Write a program that takes an integer N from the command line
 * and uses StdRandom.uniform() to generate a random sequence of integers between 0 and N – 1.
 * Run experiments to validate the hypothesis that the number of integers generated before the first repeated value is found is ~sqrt(pi*N/2)
 */
class BirthdayProblem {

    public static void main(String[] args) {
        int limit = 1000;
        double[] empiric = new double[limit];
        double[] expected = new double[limit];

        for (int i = 0; i < limit; i++) {
            int N = (i + 1) * 10;
            empiric[i] = estimateValue(N, 1000);
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
        return Math.sqrt(Math.PI * N / 2);
    }

    private static double estimateValue(int N, int repeats) {
        double trialsSum = 0;
        for (int j = 0; j < repeats; j++) {
            trialsSum += countTrialsTillFirstRepeat(N);
        }
        return trialsSum / repeats;
    }

    private static int countTrialsTillFirstRepeat(int N) {
        Set<Integer> alreadyGenerated = new HashSet<>();
        int counter = 1;
        int val = StdRandom.uniform(N);
        while (!alreadyGenerated.contains(val)) {
            alreadyGenerated.add(val);
            val = StdRandom.uniform(N);
            counter++;
        }
        return counter;
    }

}
