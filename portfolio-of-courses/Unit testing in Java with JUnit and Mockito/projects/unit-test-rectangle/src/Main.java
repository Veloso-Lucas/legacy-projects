public class Main {

    public static void main(String[] args) {

        final RectangleTest test = new RectangleTest();
        boolean result;

        result = test.testCalculateArea();
        System.out.println("testCalculateArea: " + result);

        result = test.testCalculatePerimeter();
        System.out.println("testCalculatePerimeter: " + result);
    }
}