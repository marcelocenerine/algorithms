package com.cenerino.algorithms.java.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 */
public class UniqueCharacters {

    public static boolean verify(String string) {
        Set<Character> set = new HashSet<>();

        for (char c : string.toCharArray())
            if (!set.add(c)) return false;

        return true;
    }
}
