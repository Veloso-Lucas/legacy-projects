import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    @Test
    public void testGetName() {
        final Book book = new Book("A Lua");
        final String expectedResult = "A Lua";

        final String result = book.getName();

        assertEquals(expectedResult, result);
    }
}
