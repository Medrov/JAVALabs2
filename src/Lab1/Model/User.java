package Lab1.Model;

import java.util.ArrayList;
import java.util.List;

public abstract class User {
    protected String name;
    protected List<Book> books = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    public void takeBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }
}
