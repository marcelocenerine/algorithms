package com.cenerino.algorithms.java.misc;

/**
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method to rotate the
 * image by 90 degrees. Can you do this in place?
 */
public class ImageRotation {

    public static void rotate(byte[][] image) {
        int n = image.length;
        int layersCount = n / 2;

        for (int layer = 0; layer < layersCount; layer++) {
            int minIdx = layer;
            int maxIdx = (n - 1) - layer;

            for (int i = 0; i < maxIdx - minIdx; i++) {
                byte top = image[minIdx][minIdx + i];
                // rotate left -> top
                image[minIdx][minIdx + i] = image[maxIdx - i][minIdx];
                // rotate bottom -> left
                image[maxIdx - i][minIdx] = image[maxIdx][maxIdx - i];
                // rotate right -> bottom
                image[maxIdx][maxIdx - i] = image[minIdx + i][maxIdx];
                // rotate top
                image[minIdx + i][maxIdx] = top;
            }
        }
    }
}
