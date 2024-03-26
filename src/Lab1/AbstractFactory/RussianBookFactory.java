package Lab1.AbstractFactory;

import Lab1.Model.Book;
import Lab1.Model.EducationalBook;

public class RussianBookFactory implements BookFactory {
    public Book createBook(String title) {
        return new EducationalBook(title);
    }
}
