package edu.algs.chap2.sort.stat;

import edu.princeton.cs.algs4.StdDraw;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AnimatingStatistician extends AbstractConsoleStatistician {

    private final static Logger LOG = LoggerFactory.getLogger(AnimatingStatistician.class);

    private final long waitTime;

    public AnimatingStatistician() {
        prepareCanvas();
        waitTime = 100;
    }

    public AnimatingStatistician(long waitTime){
        prepareCanvas();
        this.waitTime = waitTime;
    }

    @Override
    public void notifyCompare(Comparable left, Comparable right) {
        compares++;
    }

    @Override
    public void notifySwap(Comparable[] a, int i, int j) {
        generateDrawAndWait((Double[]) a, Math.min(i, j));
        swaps++;
    }

    @Override
    public void printReport() {
        LOG.info(buildReport());
    }

    private void generateDrawAndWait(Double[] a, int currentElement) {
        StdDraw.clear();
        doDraw(currentElement, a);
        try {
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void prepareCanvas() {
        double margin = 0.05;
        StdDraw.setCanvasSize(1024, 512);
        StdDraw.setXscale(-margin, 1 + margin);
        StdDraw.setYscale(-margin, 1 + margin);
    }

    private void doDraw(int current, Double[] arr) {
        double halfWidth = 1.0 / (2 * arr.length);
        for (int i = 0; i < arr.length; i++) {
            double x = (2 * i + 1) * halfWidth;
            double y = arr[i] / 2.0;
            toggleColor(i, current);
            StdDraw.filledRectangle(x, y, halfWidth * 0.9, y);
        }
    }

    private void toggleColor(int i, int current) {
        if (i == current) {
            StdDraw.setPenColor(StdDraw.BOOK_RED);
        } else {
            StdDraw.setPenColor(StdDraw.DARK_GRAY);
        }
    }

}
