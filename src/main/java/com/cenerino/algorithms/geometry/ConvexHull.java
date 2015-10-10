package com.cenerino.algorithms.geometry;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class ConvexHull {

    public static Stack<Point2D> solveUsingGrahanScan(Point2D[] points) {
        if (points.length < 3) throw new IllegalArgumentException("must contain at least 3 points");

        Arrays.sort(points, Point2D.Y_ORDER); // p[0] will be the point with lowest y coordinate
        Arrays.sort(points, points[0].BY_POLAR_ORDER); // sort by polar angle with respect to p[0]

        Stack<Point2D> hull = new Stack<>();
        hull.push(points[0]); // definitely on hull
        hull.push(points[1]);

        for (int i = 2; i < points.length; i++) {
            Point2D top = hull.pop();

            while (Point2D.ccw(hull.peek(), top, points[i]) <= 0) { // discard points that would not create counter-clockwise turn
                top = hull.pop();
            }

            hull.push(top);
            hull.push(points[i]);
        }

        return hull;
    }

    public static class Point2D {
        private double x;
        private double y;

        public Point2D(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public static int ccw(Point2D a, Point2D b, Point2D c) {
            double area = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
            if (area < 0) return -1; // clockwise
            if (area > 0) return 1; // counter-clockwise
            return 0; // collinear
        }

        private static final Comparator<Point2D> Y_ORDER = new Comparator<Point2D>() {
            @Override
            public int compare(Point2D a, Point2D b) {
                return Double.compare(a.y, b.y);
            }
        };

        private final Comparator<Point2D> BY_POLAR_ORDER = new Comparator<Point2D>() {
            @Override
            public int compare(Point2D a, Point2D b) {
                double x1 = a.x - x;
                double y1 = a.y - y;
                double x2 = b.x - x;
                double y2 = b.y - y;

                if (y1 >= 0 && y2 < 0) return -1; // a: above, b: below
                if (y2 >= 0 && y1 < 0) return 1; // a: below, b: above
                if (y1 == 0 && y2 == 0) { // collinear and horizontal
                    if (x1 >= 0 && x2 < 0) return -1;
                    if (x2 >= 0 && x1 < 0) return 1;
                    else return 0;
                }

                return -1 * ccw(Point2D.this, a, b); // both above or below
            }
        };

        @Override
        public String toString() {
            return String.format("(%.2f, %.2f)", x, y);
        }
    }
}
