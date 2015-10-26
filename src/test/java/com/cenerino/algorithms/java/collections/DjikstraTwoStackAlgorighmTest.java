package com.cenerino.algorithms.java.collections;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by marcelo on 12/09/15.
 */
public class DjikstraTwoStackAlgorighmTest {

    @Test
    public void shouldSolveExpression() {
        double result = new DjikstraTwoStackAlgorighm().eval(new String[]{"(" , "(", "1", "+", "(", "(", "2", "+", "3", ")", "*", "(", "4", "*", "5", ")", ")", ")"});

        Assert.assertEquals(101.0, result, 0.01);
    }
}
