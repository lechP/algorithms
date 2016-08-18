package edu.algs.chap1p2;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.*;

/**
 * 1.2.3
 * Write an Interval2D client that takes command-line arguments N, min, and max
 * and generates N random 2D intervals whose width and height are uniformly distributed between min and max
 * in the unit square.
 * Draw them on StdDraw and print the number of pairs of intervals that intersect
 * and the number of intervals that are contained in one another.
 */
public class Intervals {

    public static void main(String[] args) {
        Intervals client = new Intervals();
        client.interval1dIntersections(5);
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

}
