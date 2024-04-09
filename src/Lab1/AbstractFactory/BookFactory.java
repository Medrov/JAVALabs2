package Lab1.AbstractFactory;

import Lab1.Model.Book.EnglishBook;
import Lab1.Model.Book.RussianBook;

public interface BookFactory {
    RussianBook createRussianBook();
    EnglishBook createEnglishBook();
}
