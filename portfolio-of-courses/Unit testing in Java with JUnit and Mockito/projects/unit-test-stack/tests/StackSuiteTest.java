import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/*
* The implementation of this class serves as an example of how to run tests on
*  multiple classes simultaneously, as configured in the @Suite.SuiteClasses annotation.
*/
@RunWith(Suite.class)
@Suite.SuiteClasses({StackFixtureTest.class, BookTest.class})
public class StackSuiteTest {


}
