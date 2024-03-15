package Lab1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserBuilder {
    private String userType;
    private List<Book> books;

    public void createUser(String userType) {
        this.userType = userType;
        books = new ArrayList<>();
    }

    public void addBooks(LibraryFactory factory) {
        Random random = new Random();
        int numBooks = (userType.equals("student")) ? random.nextInt(8) + 3 : random.nextInt(6) + 3;

        for (int i = 0; i < numBooks; i++) {
            String language = (random.nextBoolean()) ? "English" : "Russian";
            String bookType = (language.equals("English")) ? "textbook" : "fiction";
            books.add(generateBook(factory, bookType, language));
        }
    }

    private Book generateBook(LibraryFactory factory, String bookType, String language) {
        if (bookType.equals("textbook")) {
            return factory.createTextbook("Title", language);
        } else {
            return factory.createFictionBook("Title", language);
        }
    }

    public String getUserType() {
        return userType;
    }

    public List<Book> getBooks() {
        return books;
    }
}
