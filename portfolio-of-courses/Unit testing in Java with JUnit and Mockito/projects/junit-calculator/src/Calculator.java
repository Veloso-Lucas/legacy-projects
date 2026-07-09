public class Calculator {

    public int sum(int a, int b) {

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return a + b;
    }

    public int divide(int a, int b) {
        if (b == 0)
            throw new ArithmeticException();

        return a/b;
    }
}
