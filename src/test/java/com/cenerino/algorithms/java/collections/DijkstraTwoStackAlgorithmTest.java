package com.cenerino.algorithms.java.collections;

import org.junit.Assert;
import org.junit.Test;

public class DijkstraTwoStackAlgorithmTest {

    @Test
    public void shouldSolveExpression() {
        double result = new DijkstraTwoStackAlgorithm().eval(new String[]{"(" , "(", "1", "+", "(", "(", "2", "+", "3", ")", "*", "(", "4", "*", "5", ")", ")", ")"});

        Assert.assertEquals(101.0, result, 0.01);
    }
}
