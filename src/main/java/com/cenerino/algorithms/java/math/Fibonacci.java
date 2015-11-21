package com.cenerino.algorithms.java.math;

import java.util.Arrays;

public class Fibonacci {

    public static long fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    public static long cachedFib(int n) {
        return cachedFib(n, new long[n]);
    }

    private static long cachedFib(int n, long[] cache) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        if (cache[n - 1] == 0) {
            cache[n - 1] = cachedFib(n - 1, cache);
        }

        if (cache[n - 2] == 0) {
            cache[n - 2] = cachedFib(n - 2, cache);
        }

        return cache[n - 1] + cache[n - 2];
    }
}
