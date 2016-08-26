package edu.algs.chap1.p4.intgen;

import edu.princeton.cs.algs4.StdRandom;

import java.util.HashSet;
import java.util.Set;

/**
 * 1.4.44  Birthday problem. Write a program that takes an integer N from the command line
 * and uses StdRandom.uniform() to generate a random sequence of integers between 0 and N – 1.
 * Run experiments to validate the hypothesis that the number of integers generated before the first repeated value is found is ~sqrt(pi*N/2)
 */
class BirthdayProblem implements Problem {

    @Override
    public double getExpectedValue(int N) {
        return Math.sqrt(Math.PI * N / 2);
    }

    @Override
    public double estimateValue(int N, int repeats) {
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
