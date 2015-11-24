package com.cenerino.algorithms.java.misc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class RomanNumeralsTest {

    @Parameter(0)
    public int arabicNumeral;

    @Parameter(1)
    public String romanNumeral;

    @Parameters
    public static Collection<Object[]> data() {
        return asList(new Object[][]{
                {1, "I"}, {2, "II"}, {3, "III"}, {4, "IV"}, {5, "V"}, {6, "VI"}, {7, "VII"}, {8, "VIII"}, {9, "IX"},
                {10, "X"}, {20, "XX"}, {30, "XXX"}, {40, "XL"}, {50, "L"}, {100, "C"}, {150, "CL"}, {200, "CC"},
                {300, "CCC"}, {400, "CD"}, {500, "D"}, {600, "DC"}, {700, "DCC"}, {800, "DCCC"}, {900, "CM"}, {1000, "M"},
                {1789, "MDCCLXXXIX"}, {10574, "MMMMMMMMMMDLXXIV"}
        });
    }

    @Test
    public void shouldConvertToRoman() {
        assertThat(RomanNumerals.encode(arabicNumeral), is(romanNumeral));
    }

    @Test
    public void shouldConvertToArabic() {
        assertThat(RomanNumerals.decode(romanNumeral), is(arabicNumeral));
    }
}
