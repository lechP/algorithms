package edu.algs.chap1.p4.intgen;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;

/**
 * Helper class to graphically check hypotheses from tasks 1.4.44 and 1.4.45
 */
public class ProblemsVerifier {

    public static void main(String[] args) {
        //run only one at a time (because of single 'canvas')
        //calculateAndPresentResults(new CouponCollectorProblem(), 500, 100);
        calculateAndPresentResults(new BirthdayProblem(), 1000, 1000);
    }

    private static void calculateAndPresentResults(Problem problem, int limit, int repeats) {

        double[] empiric = new double[limit];
        double[] expected = new double[limit];

        for (int i = 0; i < limit; i++) {
            int N = (i + 1) * 10;
            empiric[i] = problem.estimateValue(N, repeats);
            expected[i] = problem.getExpectedValue(N);
        }

        StdDraw.setXscale(-25, 1.2 * limit * 10);
        StdDraw.setYscale(-25, 1.2 * problem.getExpectedValue(limit * 10));
        StdDraw.textLeft(0, problem.getExpectedValue(limit * 10), problem.getClass().getSimpleName());
        StdDraw.setPenColor(Color.RED);
        for (int i = 0; i < limit; i++) {
            new Point2D((i + 1) * 10, empiric[i]).draw();
        }
        StdDraw.setPenColor(Color.BLUE);
        for (int i = 0; i < limit; i++) {
            new Point2D((i + 1) * 10, expected[i]).draw();
        }
    }

}
