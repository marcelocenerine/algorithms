package com.cenerino.algorithms.java.strings;

/**
 * Implement a function void reverse a string.
 */
public class Reverse {

    public static String reverse(String string) {
        char[] chars = string.toCharArray();

        for (int i = 0, j = chars.length - 1; i < chars.length / 2; i++, j--) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }

        return new String(chars);
    }
}
