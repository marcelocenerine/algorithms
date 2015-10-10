package com.cenerino.algorithms.geometry;

import com.cenerino.algorithms.geometry.ConvexHull.Point2D;
import org.junit.Test;
import org.junit.Ignore;
import java.util.Stack;

public class ConvexHullTest {

    @Ignore
    @Test
    public void shouldReturnVerticesOnConvexHull() {
        Point2D p5_0 = new Point2D(5, 0);
        Point2D p5_3 = new Point2D(5, 3);
        Point2D p5_6 = new Point2D(5, 6);
        Point2D p4_2 = new Point2D(4, 2);
        Point2D p4_4 = new Point2D(4, 4);
        Point2D p3_1 = new Point2D(3, 1);
        Point2D p3_6 = new Point2D(3, 6);
        Point2D p2_4 = new Point2D(2, 4);
        Point2D p1_2 = new Point2D(1, 2);
        Point2D p1_3 = new Point2D(1, 3);
        Point2D[] points = {p1_2, p1_3, p2_4, p3_1, p3_6, p4_2, p4_4, p5_0, p5_3, p5_6};

        Stack<Point2D> result = ConvexHull.solveUsingGrahanScan(points);

        // TODO finish tests
    }
}
