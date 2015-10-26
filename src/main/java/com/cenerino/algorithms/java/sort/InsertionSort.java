package com.cenerino.algorithms.java.sort;

/**
 * Worst case performance: O(n^2)
 * Best case performance: O(n)
 * Avg case performance: O(n^2)
 * Worst case space complexity: O(1)
 * Stable: Yes
 */
public class InsertionSort {

    public static <T extends Comparable> void sort(T[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (isLess(array[j], array[j -1])) {
                    swap(array, j, j -1);
                } else break;
            }
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
