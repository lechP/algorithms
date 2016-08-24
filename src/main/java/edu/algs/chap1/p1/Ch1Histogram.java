package edu.algs.chap1.p1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;

public class Ch1Histogram {

    public static void main(String[] args) {
        String inputFile = "/doubleInput.txt";
        In input = new In(inputFile);
        new Ch1Histogram().drawHistogram(15, -5, 10, input.readAllDoubles());
    }

    /**
     * 1.1.32
     * Histogram - takes an integer N and two double values l and r from the command line and uses StdDraw
     * to plot a histogram of the count of the numbers in the standard input stream that fall in each of the N
     * intervals defined by dividing (l , r) into N equal-sized intervals.
     * The standard input stream is a sequence of double values.
     */
    private void drawHistogram(int n, double left, double right, double[] inputStream) {
        prepareCanvas(left, right);
        doDraw(n, left, right, inputStream);
        drawGrid(left, right);
    }

    private void prepareCanvas(double left, double right) {
        double margin = 0.05 * (right - left);
        StdDraw.setXscale(left - margin, right + margin);
        StdDraw.setYscale(-0.05, 1.05);
        StdDraw.setPenColor(StdDraw.BOOK_BLUE);
    }

    private void doDraw(int n, double left, double right, double[] inputStream) {
        double halfWidth = (right - left) / (2 * n);
        int[] cardinalities = computeCardinalities(n, left, right, inputStream);
        for (int i = 0; i < n; i++) {
            double x = left + halfWidth + 2 * i * halfWidth;
            double y = cardinalities[i] / (2.0 * inputStream.length);
            StdDraw.filledRectangle(x, y, halfWidth * 0.9, y);
        }
    }

    private void drawGrid(double left, double right) {
        StdDraw.setPenColor(Color.GRAY);
        StdDraw.line(left, 0, right, 0);
        StdDraw.line(left, 0, left, 1);
    }

    int[] computeCardinalities(int n, double left, double right, double[] data) {
        int[] result = new int[n];
        for (double x : data) {
            int bucket = (int) Math.floor((x - left) / (right - left) * n);
            if (bucket >= 0 && bucket < n) result[bucket]++;
        }
        return result;
    }
}
