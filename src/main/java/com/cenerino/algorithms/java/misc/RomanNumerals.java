package com.cenerino.algorithms.java.misc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class RomanNumerals {

    private enum Numeral {
        M(1000), CM(900),  D(500), CD(400), C(100), XC(90), L(50), XL(40), X(10), IX(9), V(5), IV(4), I(1);

        private int value;

        private Numeral(int value) { this.value = value; }
    }

    public static String encode(int num) {
        StringBuilder result = new StringBuilder();
        int leftover = num;

        for (Numeral numeral : Numeral.values()) {
            while (leftover >= numeral.value) {
                result.append(numeral);
                leftover -= numeral.value;
            }
        }

        return result.toString();
    }

    public static int decode(String num) {
        int result = 0;

        List<Numeral> numerals = num.chars()
                .mapToObj(c -> Character.toString((char) c))
                .map(Numeral::valueOf)
                .collect(toList());

        for (int i = 0; i < numerals.size(); i++) {
            Numeral numeral = numerals.get(i);

            if (i + 1 < numerals.size()) {
                Numeral next = numerals.get(i + 1);

                if (numeral.value < next.value) {
                    result += next.value - numeral.value;
                    i++;
                    continue;
                }
            }

            result += numeral.value;
        }

        return result;
    }
}
