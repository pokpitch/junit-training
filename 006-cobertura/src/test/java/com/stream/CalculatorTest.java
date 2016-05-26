package com.stream;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class CalculatorTest {

    private int expected;
    private int actual;

    @Parameters
    public static Collection<Integer[]> data() {
        return Arrays.asList(new Integer[][] { { 1, 1 }, { 2, 4 }, { 3, 9 }, { 4, 16 }, { 5, 25 }, });
    }

    public CalculatorTest(int expected, int actual) {
        this.expected = expected;
        this.actual = actual;
    }

    @Test
    public void squareRoot() {
        Calculator calculator = new Calculator();
        assertEquals(expected, calculator.squareRoot(actual));
    }

}
