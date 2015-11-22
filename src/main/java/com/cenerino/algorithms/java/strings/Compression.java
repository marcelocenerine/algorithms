package com.cenerino.algorithms.java.strings;

/**
 * Implement a method to perform basic string compression using the counts of repeated characters. For example, the
 * string "aabcccccaaa" would become "a2b1c5a3". If the compressed string would not become smaller than the original
 * string, your method should return the original string.
 */
public class Compression {

    public static String compress(String original) {
        if (original.length() <= 1) return original;

        StringBuffer compressed = new StringBuffer();
        char[] chars = original.toCharArray();
        int count = 1;

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                count++;
            } else {
                compressed.append(chars[i - 1]).append(count);
                count = 1;
            }

            if (chars.length == i + 1) compressed.append(chars[i]).append(count);

            if (compressed.length() > original.length()) return original;
        }

        return compressed.toString();
    }
}
