package com.cenerino.algorithms.shuffle;

import java.util.Random;

public class KnuthShuffle {

    public static <T> void shuffle(T[] array) {
        for (int i = 0; i < array.length; i++) {
            int r = new Random().nextInt(i + 1);
            swap(array, i, r);
        }
    }

    private static <T> void swap(T[] array, int i, int j) {
        T aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }
}
