package com.cenerino.algorithms.search;

/**
 * Worst case performance: O(log n)
 * Best case performance: O(1)
 * Avg case performance: O(log n)
 * Worst case space complexity: O(1)
 */
public class BinarySearch {

    public static <T extends Comparable> int search(T[] array, T element) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int cmp = element.compareTo(array[mid]);

            if (cmp < 0)
                high = mid - 1;
            else if (cmp > 0)
                low = mid + 1;
            else return mid;
        }

        return -(low + 1);
    }
}
