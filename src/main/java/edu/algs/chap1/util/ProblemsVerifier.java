package edu.algs.chap1.util;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;

/**
 * Helper class to graphically check hypotheses of type: "complexity of some problem is ~f(N)"
 */
public class ProblemsVerifier {

    public static void calculateAndPresentResults(Problem problem, int limit, int repeats) {

        double[] empiric = new double[limit];
        double[] expected = new double[limit];

        System.out.println("Analysis starting...");
        long time = System.nanoTime();
        for (int i = 0; i < limit; i++) {
            int N = (i + 1) * 10;
            empiric[i] = problem.estimateValue(N, repeats);
            expected[i] = problem.getExpectedValue(N);
        }
        time = System.nanoTime() - time;
        System.out.println("Analysis finished. It took: " + time + " nanos | " + time * 1.0 / 1_000_000_000 + " secs");


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
