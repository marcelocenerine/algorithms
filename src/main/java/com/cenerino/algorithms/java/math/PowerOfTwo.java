package com.cenerino.algorithms.java.math;

public class PowerOfTwo {

    public static boolean isPowerOfTwo(int n) {
        if (n < 2) return false;
        return (n & (n - 1)) == 0;
    }

    public static int getNthPowerOfTwo(int n) {
        return 1 << n;
    }
}
