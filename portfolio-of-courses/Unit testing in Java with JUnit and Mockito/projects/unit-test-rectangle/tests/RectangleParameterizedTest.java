import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;

import java.util.Arrays;
import java.util.Collection;

/*
    The @RunWith is used to declare that the tests of
    this class will use a custom parameter, e.g. from a file
*/
@RunWith(Parameterized.class)
public class RectangleParameterizedTest {

    private final int base;
    private final int area;
    private final int height;

    public RectangleParameterizedTest(int base, int height, int area) {
        this.base = base;
        this.height = height;
        this.area = area;
    }

    /*
        The @Parameters declare that this is the function
        responsible for obtaining the custom parameters for the tests
    */
    @Parameters
    public static Collection<Object[]> parameters() {
        return Arrays.asList(new Object[][] {
                {10,20,200},
                {10,30,300},
                {10,40,400},
                {10,50,500},
                {10,60,600},
                {10,70,700},
                {10,80,800},
        });
    }

    @Test
    public void testCalculateArea() {

        final Rectangle rectangle = new Rectangle(base, height);
        int result = rectangle.calculateArea();

        Assert.assertEquals(area, result);

    }

    //@Test
    @Ignore
    public void testCalculatePerimeter() {

    }
}
