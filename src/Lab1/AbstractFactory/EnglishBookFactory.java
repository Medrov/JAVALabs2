package Lab1.AbstractFactory;

import Lab1.Model.Book;
import Lab1.Model.FictionBook;

public class EnglishBookFactory implements BookFactory {
    public Book createBook(String title) {
        return new FictionBook(title);
    }
}
