package Lab1.Model.Book;

public abstract class RussianBook {
    protected String type;
    protected int edition;
    public abstract String getString();

    public RussianBook(String type, int edition) {
        this.type = type;
        this.edition = edition;
    }
}