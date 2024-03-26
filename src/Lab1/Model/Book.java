package Lab1.Model;

public abstract class Book {
    protected String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
