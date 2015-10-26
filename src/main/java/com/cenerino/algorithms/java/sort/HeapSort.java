package com.cenerino.algorithms.java.sort;

/**
 * Worst case performance: O(2n log n)
 * Best case performance: O(n log n)
 * Avg case performance: O(2n log n)
 * Worst case space complexity: O(1) -> auxiliary
 * Stable: No
 */
public class HeapSort {

    public static <T extends Comparable> void sort(T[] array) {
        int n = array.length;

        for (int k = n / 2; k >= 1; k--)
            sink(array, k, n);

        while (n > 1) {
            exch(array, 1, n);
            sink(array, 1, --n);
        }
    }

    private static void sink(Comparable[] array, int k, int n) {
        // children of node k are 2k and 2k+1
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && isLess(array, j, j + 1)) j++;
            if (!isLess(array, k, j)) break;
            exch(array, k, j);
            k = j;
        }
    }

    private static boolean isLess(Comparable[] array, int i, int j) {
        // convert from 1-based indexing to 0-based indexing
        return array[i - 1].compareTo(array[j - 1]) < 0;
    }

    private static void exch(Comparable[] array, int i, int j) {
        // convert from 1-based indexing to 0-based indexing
        Comparable aux = array[i - 1];
        array[i - 1] = array[j - 1];
        array[j - 1] = aux;
    }
}
