package edu.algs.chap1.p2;

import edu.princeton.cs.algs4.*;

import java.util.*;

public class Intervals {

    public static void main(String[] args) {
        Intervals client = new Intervals();
        //client.interval1dIntersections(5);
        client.interval2dIntersections(10, 0.1, 0.75);
    }

    /**
     * 1.2.2
     * takes an int value N,
     * reads N intervals (each defined by a pair of double values) from standard input,
     * and prints all pairs that intersect.
     */
    private void interval1dIntersections(int n) {
        List<Interval1D> intervals = readIntervals(n);
        List<Set<Interval1D>> intersections = compute1dIntersections(intervals);
        printReport(intersections);
    }

    private List<Interval1D> readIntervals(int n) {
        List<Interval1D> intervals = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            StdOut.println("Reading " + i + " of " + n + " intervals. Insert two doubles separated with space:");
            intervals.add(new Interval1D(StdIn.readDouble(), StdIn.readDouble()));
        }
        return intervals;
    }

    /**
     * Computes intersections between intervals with O(n^2) complexity.
     * Sorting of intervals + (for(all intervals){while(intersects)...}) can probably improve it.
     */
    List<Set<Interval1D>> compute1dIntersections(List<Interval1D> intervals) {
        List<Set<Interval1D>> resultList = new ArrayList<>();
        for (int i = 0; i < intervals.size(); i++) {
            Interval1D first = intervals.get(i);
            for (int j = i + 1; j < intervals.size(); j++) {
                Interval1D second = intervals.get(j);
                if (first.intersects(second)) {
                    Set<Interval1D> intersection = new HashSet<>(2);
                    intersection.add(first);
                    intersection.add(second);
                    resultList.add(intersection);
                }
            }
        }
        return resultList;
    }

    private void printReport(List<Set<Interval1D>> intersections) {
        StdOut.println(intersections.size() + " intersections found.");
        for (Set<Interval1D> intersection : intersections) {
            Iterator<Interval1D> iterator = intersection.iterator();
            Interval1D first = iterator.next();
            Interval1D second = iterator.next();
            StdOut.println("Interval " + first + " intersects with " + second);
        }
    }

    /**
     * 1.2.3
     * Write an Interval2D client that takes command-line arguments N, min, and max
     * and generates N random 2D intervals whose width and height are uniformly distributed between min and max
     * in the unit square.
     * Draw them on StdDraw and print the number of pairs of intervals that intersect.
     * (in the book there is also a requirement to count how many intervals are contained in another, but
     * that would require to calculate it outside the Interval2D API, so for now is ommited)
     */
    private void interval2dIntersections(int n, double min, double max) {
        int intersections = 0;
        List<Interval2D> intervals = generateIntervals2d(n, min, max);

        for (int i = 0; i < intervals.size(); i++) {
            Interval2D first = intervals.get(i);
            first.draw();
            for (int j = i + 1; j < intervals.size(); j++) {
                Interval2D second = intervals.get(j);
                if(first.intersects(second)) intersections++;
            }
        }
        StdOut.println("Found " + intersections + " intersections.");
    }

    private List<Interval2D> generateIntervals2d(int n, double min, double max) {
        List<Interval2D> intervals = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            double x1 = StdRandom.uniform(min, max);
            double x2 = StdRandom.uniform(min, max);
            double y1 = StdRandom.uniform(min, max);
            double y2 = StdRandom.uniform(min, max);
            intervals.add(new Interval2D(
                    new Interval1D(Math.min(x1, x2), Math.max(x1, x2)),
                    new Interval1D(Math.min(y1, y2), Math.max(y1, y2))));
        }
        return intervals;
    }

}
