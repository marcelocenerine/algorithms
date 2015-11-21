package com.cenerino.algorithms.java.strings;

public class Palindrome {

    public static boolean isPalindromeWord(String word) {
        char[] chars = word.toLowerCase().toCharArray();

        for (int i = 0, j = chars.length - 1; i < chars.length / 2; i++, j--)
            if (chars[i] != chars[j]) return false;

        return true;
    }
}
