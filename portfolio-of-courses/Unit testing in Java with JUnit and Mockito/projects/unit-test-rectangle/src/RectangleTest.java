
public class RectangleTest {

    private Rectangle rectangle;

    public boolean testCalculateArea() {
        rectangle = new Rectangle(10, 2);
        final int expectedResult = 20;

        return expectedResult == rectangle.calculateArea();
    }

    public boolean testCalculatePerimeter() {
        rectangle = new Rectangle(10, 2);
        final int expectedResult = 24;

        return expectedResult == rectangle.calculatePerimeter();
    }
}
