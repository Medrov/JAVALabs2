package Lab1.AbstractFactory;

import Lab1.Model.Book;
import Lab1.Model.EducationalBook;
import Lab1.Model.FictionBook;

public class EnglishBookFactory implements BookFactory {
    public Book createBook(String title, String type) {
        if ("Educational".equalsIgnoreCase(type)) {
            return new EducationalBook(title, "English");
        } else if ("Fiction".equalsIgnoreCase(type)) {
            return new FictionBook(title, "English");
        } else {
            throw new IllegalArgumentException("Invalid book type");
        }
    }
}
