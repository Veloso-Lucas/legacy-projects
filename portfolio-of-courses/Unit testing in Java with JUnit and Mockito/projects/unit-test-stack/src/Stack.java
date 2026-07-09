import java.util.ArrayList;

public class Stack {

    private int limit = 5;
    private final ArrayList<Book> stack = new ArrayList<>();
    private final IStackDAO stackDAO;

    public Stack(final IStackDAO stackDAO) {
        this.stackDAO = stackDAO;
    }

    public void push(final Book book) {
        if (stack.size() >= limit)
         throw new ArrayStoreException();

        else if (!book.getName().startsWith("A")
                && !book.getName().startsWith("O"))
            return;

        stack.add(book);
        stackDAO.save(this);
    }

    public Book pop() {
        return stack.removeLast();
    }

    public int count() {
        return stack.size();
    }
}
