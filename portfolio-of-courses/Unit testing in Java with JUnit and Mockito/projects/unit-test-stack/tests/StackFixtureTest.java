import org.junit.*;
import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

public class StackFixtureTest {

    private static Stack stack;

    /*
        The @BeforeClass causes this function to be called before the tests are run on the class
    */
    @BeforeClass
    public static void setUpBeforeClass() {
        //stack = new Stack(new  FakeStackDAO());
        stack = new Stack(mock(IStackDAO.class));
        System.out.println("Executed setUpBeforeClass");
    }

    /*
        The @AfterClass causes this function to be called after the tests have been run on the class
    */
    @AfterClass
    public static void tearDownAfterClass() {
        stack = null;
        System.out.println("Executed tearDownAfterClass");
    }

    /*
        The @Before causes this function to be called before each test is run
    */
    @Before
    public void setUp() {
        final Book book1 = new Book("A Fortaleza");
        final Book book2 = new Book("A Emboscada");
        final Book book3 = new Book("O Palhaco");
        final Book book4 = new Book("A Terra");
        final Book book5 = new Book("O sol");

        stack.push(book1);
        stack.push(book2);
        stack.push(book3);
        stack.push(book4);
        stack.push(book5);

        System.out.println("Executed setUp");
    }

    /*
        The @After causes this function to be called after each test is run
    */
    @After
    public void tearDown() {
        int size = stack.count();
        while (size > 0) {
            stack.pop();
            size--;
        }
        System.out.println("Executed tearDown");
    }

    /*
       The @Test defines the function as a test to be executed
     */
    @Test
    public void testNoAddBookOutPatternName() {
        stack.pop();
        stack.push(new Book("Não Vale"));
        final Book book = stack.pop();

        assertEquals("A Terra", book.getName());
        System.out.println("Executed testNoAddBookOutPatternName");
    }


    /*
        The @Test defines the function as a test to be executed,

        the parameter is used to indicate the expected exception class,
        in case at some point in the test it is necessary for an exception to be thrown in the code, e.g.
        user registration with where the name cannot be null, in this case an exception should be thrown warning the user, but this would give an error in the test
        therefore, it can be added as an expected exception and the test can handle this error.
    */
    @Test(expected = ArrayStoreException.class)
    public void testNoAddBookFarLimit() {
        stack.push(new Book("A volta ao mundo"));

        System.out.println("Executed testNoAddBookFarLimit");
    }

}
