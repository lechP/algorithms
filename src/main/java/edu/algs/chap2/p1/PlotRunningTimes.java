package edu.algs.chap2.p1;

import edu.princeton.cs.algs4.StdDraw;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.util.*;
import java.util.List;

import static edu.algs.chap2.p1.SortAlg.SHELL;
import static edu.algs.chap2.p1.SortAlg.SHELL_UPGRADED;

/**
 * 2.1.32  Plot running times.
 * Write a client that uses StdDraw to plot the average running times
 * of the algorithm for random inputs and various values of the array size.
 */
public class PlotRunningTimes {

    private final static Logger LOG = LoggerFactory.getLogger(PlotRunningTimes.class);
    private static final Color[] colors = {StdDraw.BOOK_RED, StdDraw.BOOK_BLUE, StdDraw.DARK_GRAY, StdDraw.GREEN, StdDraw.BLACK};

    public enum PlotType {
        LINEAR, LOGARITHMIC
    }

    public static void main(String[] args) {
        //plotCompare(Arrays.asList(SHELL, SHELL_UPGRADED), 10, 50_000, PlotType.LOGARITHMIC, 2);
        plotCompare(Arrays.asList(SHELL, SHELL_UPGRADED), 10, 100_000, PlotType.LINEAR, 100);
    }

    public static void plotCompare(List<SortAlg> algs, int repeats, int limit, PlotType type, int plotDensity) {
        if (algs == null || algs.isEmpty()) throw new IllegalArgumentException("list of args must not be empty");

        Map<SortAlg, double[]> algsTimes = countAllTimes(algs, repeats, limit, type, plotDensity);
        int n = prepareCanvas(algs, algsTimes);
        doPlot(algs, algsTimes, n);
    }

    private static Map<SortAlg, double[]> countAllTimes(List<SortAlg> algs, int repeats, int limit, PlotType type, int plotDensity) {
        Map<SortAlg, double[]> algsTimes = new HashMap<>();
        algs.forEach(alg ->
                {
                    if (type == PlotType.LINEAR)
                        algsTimes.put(alg, countTimesLinear(alg, repeats, limit, plotDensity));
                    if (type == PlotType.LOGARITHMIC)
                        algsTimes.put(alg, countTimesLog(alg, repeats, limit, plotDensity));
                }
        );
        return algsTimes;
    }

    private static int prepareCanvas(List<SortAlg> algs, Map<SortAlg, double[]> algsTimes) {
        StdDraw.setPenRadius(0.005);
        int n = algsTimes.get(algs.get(0)).length;
        double marginX = n * 0.05;
        double maxY = countMaxVal(algsTimes.values());
        double marginY = maxY * 0.05;
        StdDraw.setXscale(-marginX, n + marginX);
        StdDraw.setYscale(-marginY, maxY + marginY);
        return n;
    }

    private static void doPlot(List<SortAlg> algs, Map<SortAlg, double[]> algsTimes, int n) {
        int colorId = 0;
        for (SortAlg alg : algs) {
            StdDraw.setPenColor(colors[colorId]);
            for (int i = 0; i < n; i++) {
                StdDraw.point(i, algsTimes.get(alg)[i]);
            }
            colorId++;

        }
    }

    private static double countMaxVal(Collection<double[]> values) {
        double[] localMaxes = new double[values.size()];
        int i = 0;
        for (double[] vals : values) {
            localMaxes[i++] = max(vals);
        }
        return max(localMaxes);
    }

    private static double[] countTimesLinear(SortAlg algorithm, int repeats, int limit, int points) {
        double[] times = new double[points];
        for (int i = 0; i < points; i++) {
            int n = limit / points * (i + 1);
            countAndLog(algorithm, repeats, times, i, n);
        }
        return times;
    }

    private static double[] countTimesLog(SortAlg algorithm, int repeats, int limit, int base) {
        double[] times = new double[(int) log(base, limit)];
        for (int i = 0; i < times.length; i++) {
            int n = (int) Math.pow(base, i + 1);
            countAndLog(algorithm, repeats, times, i, n);
        }
        return times;
    }

    private static void countAndLog(SortAlg algorithm, int repeats, double[] times, int i, int n) {
        times[i] = SortTimer.timeRandomInput(algorithm, n, repeats);
        LOG.info(String.format("Run %d of %d. N=%d. Avg. time=%.1f nanosecs.", i + 1, times.length, n, times[i]));
    }

    private static double max(double[] array) {
        double max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) max = array[i];
        }
        return max;
    }

    private static double log(int base, int number) {
        return Math.log(number) / Math.log(base);
    }

}
