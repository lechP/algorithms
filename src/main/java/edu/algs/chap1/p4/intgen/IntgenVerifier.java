package edu.algs.chap1.p4.intgen;

import edu.algs.chap1.util.ProblemsVerifier;

/**
 * Helper class to graphically check hypotheses from tasks 1.4.44 and 1.4.45
 */
public class IntgenVerifier {

    public static void main(String[] args) {
        //run only one at a time (because of single 'canvas')
        //ProblemsVerifier.calculateAndPresentResults(new CouponCollectorProblem(), 500, 100);
        ProblemsVerifier.calculateAndPresentResults(new BirthdayProblem(), 1000, 1000);
    }

}
