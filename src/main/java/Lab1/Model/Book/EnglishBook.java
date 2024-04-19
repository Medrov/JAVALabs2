package main.java.Lab1.Model.Book;

public abstract class EnglishBook {
    protected String author;
    protected int year;
    public abstract String getString();

    public EnglishBook(String author, int year) {
        this.author = author;
        this.year = year;
    }
}
