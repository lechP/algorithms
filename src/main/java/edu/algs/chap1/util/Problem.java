package edu.algs.chap1.util;

/**
 * Interface to provide common methods in problems of type: "complexity of some problem is ~f(N)"
 */
public interface Problem {

    double getExpectedValue(int N);

    double estimateValue(int N, int repeats);

}
