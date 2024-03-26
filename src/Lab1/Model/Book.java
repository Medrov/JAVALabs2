package Lab1.Model;

public abstract class Book {
    protected String title;
    protected String language;

    public Book(String title, String language) {
        this.title = title;
        this.language = language;
    }

    public String getTitle() {
        return title;
    }

    public String getLanguage() {
        return language;
    }
}
