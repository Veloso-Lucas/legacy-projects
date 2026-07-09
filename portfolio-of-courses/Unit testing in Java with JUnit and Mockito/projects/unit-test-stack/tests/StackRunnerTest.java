import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.List;

/*
 * Implementation on how to run the tests written from the code
 * without using the IDE implementation
*/
public class StackRunnerTest {

    public static void main(String[] args) {
        final Result result = JUnitCore.runClasses(BookTest.class, StackFixtureTest.class);

        final List<Failure> failure = result.getFailures();
        failure.forEach(fail -> System.out.println("Fail Message: " + fail.getMessage()));

        System.out.println("Tests Result: " + result.wasSuccessful());
    }
}
