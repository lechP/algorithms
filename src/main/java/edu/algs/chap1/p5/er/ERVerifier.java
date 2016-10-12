package edu.algs.chap1.p5.er;

import edu.algs.chap1.util.ProblemsVerifier;

public class ERVerifier {

    public static void main(String[] args) {
        //run only one at a time (because of single 'canvas')
        //ProblemsVerifier.calculateAndPresentResults(new CouponCollectorProblem(), 500, 100);
        ProblemsVerifier.calculateAndPresentResults(new ErdosRenyi(), 1000, 100);
    }

}
