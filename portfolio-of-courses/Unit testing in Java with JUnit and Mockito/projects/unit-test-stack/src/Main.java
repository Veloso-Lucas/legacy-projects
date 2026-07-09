//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        final StackTest stackTest = new StackTest();
        boolean result;

        result = stackTest.testNoAddBookFarLimit();
        System.out.println("testNoAddBookFarLimit: " + result);

        result = stackTest.testPopLastBook();
        System.out.println("testPopLastBook: " + result);

        result = stackTest.testNoAddBookOutPatternName();
        System.out.println("testNoAddBookOutPatternName: " + result);
    }
}