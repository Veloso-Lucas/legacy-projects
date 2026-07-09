import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;



/*
    The @FixMethodOrder annotation is used to order the sequence of tests to be performed,
    the parameter passed is used to determine which type of ordering will be used.

    OBS. Pointing out that, as a matter of good practice, tests should not be influenced by an order
*/
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CalculatorTest {

    /*
       The @Test defines the function as a test to be executed,

       the parameter 'timeout' is used to define a period of time in ms where the test should fail,
       in this example if the test takes more than 200 ms to run it will be considered a failure regardless of the result of the sum.
     */
    @Test(timeout = 300 /*ms*/ )
    public void testSum() {
        final Calculator calculator = new Calculator();
        final int expectedResult = 10;

        final int result = calculator.sum(4, 6);

        // Function that checks if the condition is true
        assertTrue(expectedResult == result);
    }


    @Test
    public void testNegativeSum() {
        final Calculator calculator = new Calculator();

        final int result = calculator.sum(-4, -6);

        // Function that checks if the two parameters are equal
        assertEquals(-10, result);
    }

    /*
       The @Ignore causes the function that has this annotation to be ignored in the execution of the tests
     */
    @Ignore
    public void testIgnored() {
        final Calculator calculator = new Calculator();
        final int expectedResult = 12;

        final int result = calculator.sum(4, 6);
        assertEquals(expectedResult, result);
    }

    /*
        The @Test defines the function as a test to be executed,

        the parameter 'expected' is used to indicate the expected exception class,
        in case at some point in the test it is necessary for an exception to be thrown in the code, e.g.
        user registration with where the name cannot be null, in this case an exception should be thrown warning the user, but this would give an error in the test
        therefore, it can be added as an expected exception and the test can handle this error.
    */
    @Test(expected = ArithmeticException.class)
    public void testDivisionByZero() {
        final Calculator calculator = new Calculator();

        final int a = 20;
        final int b = 0;

        calculator.divide(a, b);
    }

    @Test()
    public void testDivision() {
        final Calculator calculator = new Calculator();

        final int a = 20;
        final int b = 2;

        final int result = calculator.divide(a, b);

        assertEquals(10, result);
    }
}