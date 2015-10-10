package com.cenerino.algorithms.sort;

/**
 * Worst case performance: O(n^2)
 * Best case performance: O(n^2)
 * Avg case performance: O(n^2)
 * Worst case space complexity: O(1)
 * Stable: No
 */
public class SelectionSort {

    public static <T extends Comparable> void sort(T[] array) {
        for (int i = 0; i < array.length -1; i++) {
            int min = i;

            for (int j = i + 1; j < array.length; j++) {
                if (isLess(array[j], array[min])) {
                    min = j;
                }
            }

            swap(array, i, min);
        }
    }

    private static boolean isLess(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static <T> void swap(T[] array, int i, int j) {
        T aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }
}
