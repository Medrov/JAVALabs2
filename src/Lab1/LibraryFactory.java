package Lab1;

public interface LibraryFactory {
    Book createTextbook(String title, String language);
    Book createFictionBook(String title, String language);
}
