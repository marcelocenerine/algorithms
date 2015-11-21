package com.cenerino.algorithms.java.strings;

import java.util.Arrays;

/**
 * Given two strings, write a method to decide if one is a permutation of the other.
 */
public class Permutation {

    public static boolean isPermutation(String original, String permutation) {
        char[] originalChars = original.toCharArray();
        char[] permChars = permutation.toCharArray();

        Arrays.sort(originalChars);
        Arrays.sort(permChars);

        return Arrays.equals(originalChars, permChars);
    }
}
