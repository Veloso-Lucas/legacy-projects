public class StackTest {

    private final Stack stack = new Stack(new  FakeStackDAO());

    public boolean testPopLastBook() {
        Book book = new Book("A Fortaleza");
        stack.push(book);

        book = new Book("A Emboscada");
        stack.push(book);

        book = new Book("O Naufrago");
        stack.push(book);

        final String expectedResult = "O Naufrago";

        return stack.pop().getName().equals(expectedResult);
    }

    public boolean testNoAddBookFarLimit() {
        final Stack stack1 = new Stack(new  FakeStackDAO());
        final Book book1 = new Book("A Fortaleza");
        final Book book2 = new Book("A Emboscada");
        final Book book3 = new Book("O Palhaco");
        final Book book4 = new Book("A Terra");
        final Book book5 = new Book("O sol");
        final Book book6 = new Book("A lua");

        stack1.push(book1);
        stack1.push(book2);
        stack1.push(book3);
        stack1.push(book4);
        stack1.push(book5);
        stack1.push(book6);

        final String expectedResult = "O sol";

        return stack1.pop().getName().equals(expectedResult);
    }


    public boolean testNoAddBookOutPatternName() {
        final Stack stack1 = new Stack(new  FakeStackDAO());
        final Book book1 = new Book("A Fortaleza");
        stack1.push(book1);

        final Book book2 = new Book("Homem de ferro");
        stack1.push(book2);

        final String expectedResult = "A Fortaleza";
        return stack1.pop().getName().equals(expectedResult);
    }
}
