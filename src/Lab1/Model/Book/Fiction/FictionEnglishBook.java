package Lab1.Model.Book.Fiction;

import Lab1.Model.Book.EnglishBook;

public class FictionEnglishBook extends EnglishBook {
    private final String title;
    private final String level;

    public FictionEnglishBook(String author, int year, String title, String level) {
        super(author, year);
        this.title = title;
        this.level = level;
    }

    @Override
    public String getString() {
        return String.join(" ", title, author, year + "г", level);
    }

}
