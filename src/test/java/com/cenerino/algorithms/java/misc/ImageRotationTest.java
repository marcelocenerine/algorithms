package com.cenerino.algorithms.java.misc;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ImageRotationTest {

    @Test
    public void shouldRotateImageOfSize0x0() {
        byte[][] image = {};

        ImageRotation.rotate(image);

        byte[][] expected = {};

        assertThat(image, is(expected));
    }

    @Test
    public void shouldRotateImageOfSize1x1() {
        byte[][] image = {{0}};

        ImageRotation.rotate(image);

        byte[][] expected = {{0}};
        assertThat(image, is(expected));
    }

    @Test
    public void shouldRotateImageOfSize2x2() {
        byte[][] image = {{0, 1},
                          {2, 3}};

        ImageRotation.rotate(image);

        byte[][] expected = {{2, 0},
                             {3, 1}};
        assertThat(image, is(expected));
    }

    @Test
    public void shouldRotateImageOfSize3x3() {
        byte[][] image = {{0, 1, 2},
                          {3, 4, 5},
                          {6, 7, 8}};

        ImageRotation.rotate(image);

        byte[][] expected = {{6, 3, 0},
                             {7, 4, 1},
                             {8, 5, 2}};
        assertThat(image, is(expected));
    }

    @Test
    public void shouldRotateImageOfSize4x4() {
        byte[][] image = {{0,   1,  2,  3},
                          {4,   5,  6,  7},
                          {8,   9, 10, 11},
                          {12, 13, 14, 15}};

        ImageRotation.rotate(image);

        byte[][] expected = {{12,  8,  4,  0},
                             {13,  9,  5,  1},
                             {14, 10,  6,  2},
                             {15, 11,  7,  3}};
        assertThat(image, is(expected));
    }

    @Test
    public void shouldRotateImageOfSize5x5() {
        byte[][] image = {{ 0,  1,  2,  3,  4},
                          { 5,  6,  7,  8,  9},
                          {10, 11, 12, 13, 14},
                          {15, 16, 17, 18, 19},
                          {20, 21, 22, 23, 24}};

        ImageRotation.rotate(image);

        byte[][] expected = {{20, 15, 10, 5, 0},
                             {21, 16, 11, 6, 1},
                             {22, 17, 12, 7, 2},
                             {23, 18, 13, 8, 3},
                             {24, 19, 14, 9, 4}};
        assertThat(image, is(expected));
    }
}
