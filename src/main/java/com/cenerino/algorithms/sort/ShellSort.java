package com.cenerino.algorithms.sort;

/**
 * Worst case performance: O(n^2)
 * Best case performance: O(n log^2 n)
 * Avg case performance: depends on gap sequence
 * Worst case space complexity: O(1)
 * Stable: No
 */
public class ShellSort {

    public static <T extends Comparable> void sort(T[] array) {
        int n = array.length;
        int h = 1;

        while (h < n / 3) {
            h = 3 * h + 1; // 3x+1 sequence = 1, 4, 13, 40, 121, ...
        }

        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (isLess(array[j], array[j - h])) {
                        swap(array, j, j - h);
                    } else break;
                }
            }

            h = h / 3;
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
