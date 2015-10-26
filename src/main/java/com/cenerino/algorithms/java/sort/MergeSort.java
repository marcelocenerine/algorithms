package com.cenerino.algorithms.java.sort;

/**
 * Worst case performance: O(n log n)
 * Best case performance: O(n log n)
 * Avg case performance: O(n log n)
 * Worst case space complexity: O(n)
 * Stable: Yes
 */
public class MergeSort {

    public static void sort(Comparable[] array) {
        Comparable[] aux = new Comparable[array.length];
        sort(array, aux, 0, array.length -1);
    }

    private static void sort(Comparable[] array, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) return;

        int mid = lo + (hi - lo) / 2;
        sort(array, aux, lo, mid);
        sort(array, aux, mid + 1, hi);
        merge(array, aux, lo, mid, hi);
    }

    private static void merge(Comparable[] array, Comparable[] aux, int lo, int mid, int hi) {
        for (int x = lo; x <= hi; x++) { // copy elements to auxiliary array
            aux[x] = array[x];
        }

        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid) array[k] = aux[j++];
            else if (j > hi) array[k] = aux[i++];
            else if (aux[i].compareTo(aux[j]) > 0) array[k] = aux[j++];
            else array[k] = aux[i++];
        }
    }
}
