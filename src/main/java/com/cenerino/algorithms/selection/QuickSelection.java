package com.cenerino.algorithms.selection;

import com.cenerino.algorithms.shuffle.KnuthShuffle;

public class QuickSelection {

    public static <T extends Comparable> T select(T[] array, int k) {
        KnuthShuffle.shuffle(array);

        int lo = 0;
        int hi = array.length - 1;

        while (hi > lo) {
            int j = partition(array, lo, hi);

            if (j < k) lo = j + 1;
            else if (j > k) hi = j - 1;
            else break;
        }

        return array[k];
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
