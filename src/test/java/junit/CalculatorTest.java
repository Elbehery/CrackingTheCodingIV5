package junit;


import JUNIT.Calculator;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by mustafa on 03.04.16.
 */
@RunWith(value = Parameterized.class)
public class CalculatorTest {

    private int expected;
    private int valueOne;
    private int valueTwo;

    @Parameterized.Parameters
    public static Collection<Integer[]> getTestParameters() {

        return Arrays.asList(new Integer[][]{

                {2, 1, 1},
                {3, 2, 1},
                {4, 3, 1},
        });
    }

    public CalculatorTest(int expected, int valueOne, int valueTwo) {

        this.expected = expected;
        this.valueOne = valueOne;
        this.valueTwo = valueTwo;

    }


    @Test
    public void testAdd() {

        Calculator calculator = new Calculator();
        int result = calculator.add(valueOne, valueTwo);
        Assert.assertEquals("Calculator add method returns incorrect addition", expected, result);
    }
}
