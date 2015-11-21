package com.cenerino.algorithms.java.misc;

/**
 * Sum digits of an integer without converting it to String and splitting the characters.
 */
public class SumDigits {

    public static int calc(int num) {
        num = Math.abs(num);
        int result = 0;

        while (num > 0) {
            result += num % 10;
            num = num / 10;
        }

        return result;
    }
}
