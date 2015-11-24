package com.cenerino.algorithms.java.strings;

import java.util.*;

import static java.util.Collections.emptyList;


public class Permutation {

    /**
     * Given two strings, write a method to decide if one is a permutation of the other.
     */
    public static boolean isPermutation(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        char[] originalChars = str1.toCharArray();
        char[] permChars = str2.toCharArray();

        Arrays.sort(originalChars);
        Arrays.sort(permChars);

        return Arrays.equals(originalChars, permChars);
    }

    /**
     * Write a method to compute all permutations of a string
     */
    public static Set<String> generatePermutations(String str) {
        if (str == null) return null;

        Set<String> permutations = new TreeSet<>();

        if (str.length() <= 1) {
            permutations.add(str);
            return permutations;
        }

        char first = str.charAt(0);
        String leftover = str.substring(1);

        for (String perm : generatePermutations(leftover)) {
            for (int i = 0; i <= perm.length(); i++) {
                permutations.add(insertCharAt(first, perm, i));
            }
        }

        return permutations;
    }

    private static String insertCharAt(char first, String perm, int i) {
        return perm.substring(0, i) + first + perm.substring(i);
    }
}
