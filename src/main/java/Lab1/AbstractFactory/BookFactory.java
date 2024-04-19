package main.java.Lab1.AbstractFactory;

import main.java.Lab1.Model.Book.EnglishBook;
import main.java.Lab1.Model.Book.RussianBook;

public interface BookFactory {
    RussianBook createRussianBook();
    EnglishBook createEnglishBook();
}
