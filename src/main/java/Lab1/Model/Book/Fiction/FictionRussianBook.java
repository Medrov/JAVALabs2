package main.java.Lab1.Model.Book.Fiction;

import main.java.Lab1.Model.Book.RussianBook;

public class FictionRussianBook extends RussianBook {
    private final String title;
    private final String author;

    public FictionRussianBook(String type, int edition, String title, String author) {
        super(type, edition);
        this.title = title;
        this.author = author;
    }

    @Override
    public String getString() {
        return String.join(" ", type, "'", title, "'", author, edition + "-е", "издание");
    }
}
