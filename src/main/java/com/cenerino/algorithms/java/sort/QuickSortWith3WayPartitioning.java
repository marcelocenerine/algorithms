package com.cenerino.algorithms.java.sort;

import com.cenerino.algorithms.java.shuffle.KnuthShuffle;

/**
 * Worst case performance: O(n^2) -> rare
 * Best case performance: O(n) -> equal keys
 * Avg case performance: O(n log n)
 * Worst case space complexity: O(log n)
 * Stable: No
 */
public class QuickSortWith3WayPartitioning {

    public static void sort(Comparable[] array) {
        KnuthShuffle.shuffle(array); // shuffle needed for performance guarantee
        sort(array, 0, array.length - 1);
    }

    private static void sort(Comparable[] array, int lo, int hi) {
        if (hi <= lo) return;

        int lt = lo;
        int gt = hi;
        Comparable v = array[lo];
        int i = lo;

        while (i <= gt) {
            int comp = array[i].compareTo(v);

            if (comp < 0) exchange(array, lt++, i++);
            else if (comp > 0) exchange(array, i, gt--);
            else i++;
        }

        sort(array, lo, lt - 1);
        sort(array, gt + 1, hi);
    }

    private static void exchange(Comparable[] array, int i, int j) {
        Comparable aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }
}
