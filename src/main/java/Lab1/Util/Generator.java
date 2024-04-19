package main.java.Lab1.Util;

import main.java.Lab1.AbstractFactory.EducationalBookFactory;
import main.java.Lab1.AbstractFactory.FictionBookFactory;
import main.java.Lab1.Factory.UserFactory;
import main.java.Lab1.Model.Book.EnglishBook;
import main.java.Lab1.Model.Book.RussianBook;
import main.java.Lab1.Model.User;

import java.util.*;

public class Generator {
    private static final Random random = new Random();

    private static Set<EnglishBook> makeSetOfEnglishBooks() {
        Set<EnglishBook> books = new HashSet<>();
        for (int i = 0; i < 60; i++) {
            books.add(random.nextBoolean() ? EducationalBookFactory.getInstance().createEnglishBook() :
                    FictionBookFactory.getInstance().createEnglishBook());
        }
        return books;
    }

    private static Set<RussianBook> makeSetOfRussianBooks() {
        Set<RussianBook> books = new HashSet<>();
        for (int i = 0; i < 60; i++) {
            books.add(random.nextBoolean() ? FictionBookFactory.getInstance().createRussianBook() :
                    EducationalBookFactory.getInstance().createRussianBook());
        }
        return books;
    }

    private static List<User> makeListOfUsers(int numberOfUsers) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < numberOfUsers; i++) {
            users.add(random.nextBoolean() ? UserFactory.getInstance().createUser("Teacher") :
                    UserFactory.getInstance().createUser("Student"));
        }
        return users;
    }

    public static User[] generateUsers(int numberOfUsers) {
        List<User> listOfUsers = makeListOfUsers(numberOfUsers);
        User[] users = new User[numberOfUsers];
        for (int i = 0; i < numberOfUsers; i++) {
            users[i] = listOfUsers.get(i);
        }
        distributeBooks(users);
        return users;
    }

    private static void distributeBooks(User[] users) {
        List<EnglishBook> engBooks = new ArrayList<>(makeSetOfEnglishBooks());
        List<RussianBook> ruBooks = new ArrayList<>(makeSetOfRussianBooks());
        for (User user : users) {
            int numberOfBooks = random.nextInt(3, 11);
            int item;
            for (int j = 0; j < numberOfBooks; j++) {
                if (random.nextBoolean()) {
                    do {
                        item = random.nextInt(engBooks.size());
                    } while (user.isEnglishBookInList(engBooks.get(item)));
                    user.englishBooks.add(engBooks.get(item));
                } else {
                    do {
                        item = random.nextInt(ruBooks.size());
                    } while (user.isRussianBookInList(ruBooks.get(item)));
                    user.russianBooks.add(ruBooks.get(item));
                }
            }
        }
    }
}
