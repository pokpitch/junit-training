package com.stream;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class CalculatorSumTest {

    private int expected;
    private int numberOne;
    private int numberTwo;

    @Parameters
    public static Collection<Integer[]> data() {
        return Arrays.asList(new Integer[][] {
          { 6, 1, 5},
          { 6, 2, 4 },
          { 12, 3, 9 },
          { 20, 4, 16 },
          { 30, 5, 25 },
      });
    }

    public CalculatorSumTest(int expected, int numberOne, int numberTwo) {
        this.expected = expected;
        this.numberOne = numberOne;
        this.numberTwo = numberTwo;
    }

    @Test
    public void sum() {
        Calculator calculator = new Calculator();
        assertEquals(expected, calculator.sum(numberOne, numberTwo));
    }

}
