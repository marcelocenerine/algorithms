package com.cenerino.algorithms.java.sort;

import com.cenerino.algorithms.java.shuffle.KnuthShuffle;

/**
 * Worst case performance: O(n^2) -> rare
 * Best case performance: O(n log n)
 * Avg case performance: O(n log n)
 * Worst case space complexity: O(log n)
 * Stable: No
 */
public class QuickSort {

    public static void sort(Comparable[] array) {
        KnuthShuffle.shuffle(array); // shuffle needed for performance guarantee
        sort(array, 0, array.length -1);
    }

    private static void sort(Comparable[] array, int lo, int hi) {
        if (hi <= lo) return;

        int j = partition(array, lo, hi);
        sort(array, lo, j - 1);
        sort(array, j + 1, hi);
    }


    private static int partition(Comparable[] array, int lo, int hi) {
        int i = lo;
        int j = hi + 1;

        while (true) {
            while (less(array[++i], array[lo])) // find item on the left to swap
                if (i == hi) break;

            while (less(array[lo], array[--j])) // find item on the right to swap
                if (j == lo) break;

            if (i >= j) break; // check if pointers cross

            exchange(array, i, j); // swap
        }

        exchange(array, lo, j); // swap with partitioning item
        return j; // return the index of the item now known to be in place
    }

    private static void exchange(Comparable[] array, int i, int j) {
        Comparable aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
}
