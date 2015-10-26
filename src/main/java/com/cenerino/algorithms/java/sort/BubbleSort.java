package com.cenerino.algorithms.java.sort;

/**
 * Worst case performance: O(n^2)
 * Best case performance: O(n)
 * Avg case performance: O(n^2)
 * Worst case space complexity: O(1) -> auxiliary
 * Stable: Yes
 */
public class BubbleSort {

    public static <T extends Comparable> void sort(T[] array) {
        boolean swapped = true;
        int j = 0;

        while (swapped) {
            swapped = false;
            j++;

            for (int i = 0; i < array.length - j; i++) {
                if (isLess(array[i + 1], array[i])) {
                    swap(array, i, i + 1);
                    swapped = true;
                }
            }
        }
    }

    private static boolean isLess(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void swap(Comparable[] array, int i, int j) {
        Comparable aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }
}
