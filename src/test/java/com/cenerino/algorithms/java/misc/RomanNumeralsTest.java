package com.cenerino.algorithms.java.misc;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RomanNumeralsTest {

    private int[] arabicNumerals = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 30, 40,
            50, 100, 150, 200, 300, 400, 500, 600, 700, 800, 900, 1000, 1789, 10574};
    private String[] romanNumerals = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XX", "XXX", "XL",
            "L", "C", "CL", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM", "M", "MDCCLXXXIX", "MMMMMMMMMMDLXXIV"};

    @Test
    public void shouldConvertToRoman() {
        for (int i = 0; i < arabicNumerals.length ; i++) {
            assertThat(RomanNumerals.encode(arabicNumerals[i]), is(romanNumerals[i]));
        }
    }

    @Test
    public void shouldConvertToArabic() {
        for (int i = 0; i < romanNumerals.length ; i++) {
            assertThat(RomanNumerals.decode(romanNumerals[i]), is(arabicNumerals[i]));
        }
    }
}
