package Lab1.Builder;

import Lab1.AbstractFactory.BookFactory;
import Lab1.Model.Teacher;

import java.util.Random;

public class TeacherBuilder extends UserBuilder {
    public TeacherBuilder(String name) {
        super(name);
    }

    public void createUser() {
        user = new Teacher(name);
    }

    public void addBooks(BookFactory bookFactory) {
        Random random = new Random();
        int numBooks = random.nextInt(8) + 3;
        for (int i = 0; i < numBooks; i++) {
            user.takeBook(bookFactory.createBook("Book Title " + (i + 1)));
        }
    }
}
