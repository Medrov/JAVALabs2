package Lab1.AbstractFactory;

import Lab1.Model.Book;

public interface BookFactory {
    Book createBook(String title, String type);
}
