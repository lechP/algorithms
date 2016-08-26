package edu.algs.chap1.p4.autoboxing;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 1.4.37  Autoboxing performance penalty. Run experiments to determine the performance penalty on your machine
 * for using autoboxing and auto-unboxing. Develop an implementation FixedCapacityStackOfInts
 * and use a client such as DoublingRatio to compare its performance with the generic FixedCapacityStack<Integer>,
 * for a large number of push() and pop() operations.
 *
 * Observation: the difference is not statistically significant
 */
class AutoboxingPerformanceChecker {

    public static void main(String[] args) {
        FixedCapacityStack<Integer> genericStack = new FixedCapacityStack<>(1);
        FixedCapacityStackOfInts fixedIntStack = new FixedCapacityStackOfInts(1);

        double prevGeneric = timeTrialGeneric(125, genericStack);
        double prevFix = timeTrialFixed(125, fixedIntStack);
        for (int N = 250; N > 0; N += N) {
            double actualGeneric = timeTrialGeneric(N, genericStack);
            double actualFix = timeTrialFixed(N, fixedIntStack);
            StdOut.printf("%6d %7.1f %7.1f ", N, actualGeneric, actualFix);
            StdOut.printf("%5.1f %5.1f\n", actualGeneric / prevGeneric, actualFix / prevFix);
            prevGeneric = actualGeneric;
            prevFix = actualFix;
        }
    }

    private static double timeTrialGeneric(int n, FixedCapacityStack<Integer> stack) {
        long t0 = System.nanoTime();
        for (int i = 0; i < n; i++) {
            int item = StdRandom.uniform(100);
            stack.push(item);
            stack.pop();
        }
        return System.nanoTime() - t0;
    }

    private static double timeTrialFixed(int n, FixedCapacityStackOfInts stack) {
        long t0 = System.nanoTime();
        for (int i = 0; i < n; i++) {
            int item = StdRandom.uniform(100);
            stack.push(item);
            stack.pop();
        }
        return System.nanoTime() - t0;
    }


}
