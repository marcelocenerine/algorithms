package com.cenerino.algorithms.java.strings;

import java.util.Arrays;

/**
 * Given two strings, write a method to decide if one is a permutation of the other.
 */
public class Permutation {

    public static boolean isPermutation(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        char[] originalChars = str1.toCharArray();
        char[] permChars = str2.toCharArray();

        Arrays.sort(originalChars);
        Arrays.sort(permChars);

        return Arrays.equals(originalChars, permChars);
    }
}
