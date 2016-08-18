package edu.algs.chap1p1;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;


public class Ch1RandomConnections {

    public static void main(String[] args) {
        new Ch1RandomConnections().drawRandomConnections(100, 0.1);
    }

    /**
     * 1.1.31 Random connections.
     * Takes as command-line arguments an integer N and a double value p (between 0 and 1),
     * plots N equally spaced dots on the circumference of a circle, and then,
     * with probability p for each pair of points, draws a gray line connecting them.
     */
    private void drawRandomConnections(int n, double p) {
        double radius = 1;
        initCanvas(radius);
        Point2D[] points = drawPoints(n, radius);
        int connections = drawConnections(p, points);
        addLegend(connections);
    }

    private void initCanvas(double radius) {
        StdDraw.setScale(-1.2, 1.2);
        StdDraw.circle(0, 0, radius);
        StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor(Color.RED);
    }

    private Point2D[] drawPoints(int n, double radius) {
        Point2D[] points = new Point2D[n];
        double theta = 2 * Math.PI / n;
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point2D(radius * Math.sin(i * theta), radius * Math.cos(i * theta));
            StdDraw.point(points[i].x(), points[i].y());
        }
        return points;
    }

    private int drawConnections(double p, Point2D[] points) {
        StdDraw.setPenRadius(0.002);
        StdDraw.setPenColor(Color.GRAY);
        int connections = 0;
        for (int i = 0; i < points.length; i++) {
            Point2D pointA = points[i];
            for (int j = i + 1; j < points.length; j++) {
                Point2D pointB = points[j];
                boolean connected = StdRandom.bernoulli(p);
                if (connected) {
                    StdDraw.line(pointA.x(), pointA.y(), pointB.x(), pointB.y());
                    connections++;
                }
            }
        }
        return connections;
    }

    private void addLegend(int connections) {
        StdDraw.setPenColor();
        StdDraw.textLeft(-1.1, 1.1, "Connections count: " + connections);
    }

}
