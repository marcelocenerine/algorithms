package com.cenerino.algorithms.java.strings;

/**
 * Assume you have a method isSubstring which checks if one word is a substring of another. Given two strings, si and s2,
 * write code to check if s2 is a rotation of si using only one call to isSubstring (e.g.,"waterbottle" is a rotation of
 * "erbottlewat"
 */
public class Rotation {

    public static boolean isRotation(String str1, String str2) {
        return isSubstring(str1 + str1, str2);
    }

    private static boolean isSubstring(String str1, String str2) {
        return str1.contains(str2);
    }
}
