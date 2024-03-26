package Lab1.AbstractFactory;

import Lab1.Model.Book;
import Lab1.Model.EducationalBook;
import Lab1.Model.FictionBook;

public class RussianBookFactory implements BookFactory {
    public Book createBook(String title, String type) {
        if ("Educational".equalsIgnoreCase(type)) {
            return new EducationalBook(title, "Russian");
        } else if ("Fiction".equalsIgnoreCase(type)) {
            return new FictionBook(title, "Russian");
        } else {
            throw new IllegalArgumentException("Invalid book type");
        }
    }
}
