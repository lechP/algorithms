package edu.algs.chap1.p1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * 1.1.35
 * Dice simulation.
 * The value dist[k] is the probability that the dice sum to k.
 * Run experiments to validate this calculation simulating N dice throws,
 * keeping track of the frequencies of occurrence of each value
 * when you compute the sum of two random integers between 1 and 6.
 * How large does N have to be before your empirical results match the exact results to three decimal places?
 */
public class Ch1Dices {

    public static void main(String[] args) {
        Ch1Dices dices = new Ch1Dices();
        StdOut.print(dices.getDifferenceReport(dices.simulateDicesThrows(1000000)));
        StdOut.print("Number of throws needed to achieve 0.001 accuracy: " + dices.getNumberOfSimulationsForDesiredAccuracy(0.001));
    }

    private static final int SIDES = 6;
    private double[] dicesDist;

    private Ch1Dices() {
        computeDicesDistribution();
    }

    private void computeDicesDistribution() {
        dicesDist = new double[2 * SIDES + 1];
        for (int i = 1; i <= SIDES; i++) {
            for (int j = 1; j <= SIDES; j++) {
                dicesDist[i + j]++;
            }
        }
        for (int k = 2; k <= 2 * SIDES; k++) {
            dicesDist[k] /= 36;
        }
    }

    private double[] simulateDicesThrows(int n) {
        double[] empDist = new double[2 * SIDES + 1];
        for (int i = 0; i < n; i++) {
            int dice1 = StdRandom.uniform(1, 7);
            int dice2 = StdRandom.uniform(1, 7);
            empDist[dice1 + dice2]++;
        }
        for (int i = 0; i < empDist.length; i++) {
            empDist[i] /= n;
        }
        return empDist;
    }

    private String getDifferenceReport(double[] empDist) {
        String header = "score\t" + "emp\t" + "exact\t" + "diff\t" + "% diff\n\n";
        String content = "";
        DecimalFormat df = new DecimalFormat("#.####");
        df.setRoundingMode(RoundingMode.CEILING);
        for (int i = 2; i < empDist.length; i++) {
            double delta = empDist[i] - dicesDist[i];
            content += i + "\t"
                    + df.format(empDist[i]) + "\t"
                    + df.format(dicesDist[i]) + "\t"
                    + df.format(delta) + "\t"
                    + df.format(delta / dicesDist[i] * 100) + "%\n";
        }
        return header + content;
    }

    private int getNumberOfSimulationsForDesiredAccuracy(double accuracy) {
        int count = 0;
        int[] empFrequency = new int[2 * SIDES + 1];
        double[] empDist = new double[2 * SIDES + 1];
        while (isDifferenceHigher(empDist, accuracy)) {
            int dice1 = StdRandom.uniform(1, 7);
            int dice2 = StdRandom.uniform(1, 7);
            empFrequency[dice1 + dice2]++;
            count++;
            for (int i = 2; i < empDist.length; i++) {
                empDist[i] = empFrequency[i] * 1.0 / count;
            }
        }
        return count;
    }

    private boolean isDifferenceHigher(double[] empDist, double accuracy) {
        for (int i = 0; i < empDist.length; i++) {
            double diff = Math.abs(empDist[i] - dicesDist[i]);
            if (diff > accuracy) return true;
        }
        return false;
    }


}
