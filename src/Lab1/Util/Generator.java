package Lab1.Util;

import Lab1.AbstractFactory.EducationalBookFactory;
import Lab1.AbstractFactory.FictionBookFactory;
import Lab1.Factory.UserFactory;
import Lab1.Model.Book.EnglishBook;
import Lab1.Model.Book.RussianBook;
import Lab1.Model.User;

import java.util.*;

public class Generator {
    private static final Random random = new Random();

    private static Set<EnglishBook> returnSetOfEnglishBooks() {
        Set<EnglishBook> books = new HashSet<>();
        EducationalBookFactory eduBookFactory = new EducationalBookFactory();
        FictionBookFactory fictionBookFactory = new FictionBookFactory();
        for (int i = 0; i < 60; i++) {
            books.add(random.nextBoolean() ? eduBookFactory.createEnglishBook() :
                    fictionBookFactory.createEnglishBook());
        }
        return books;
    }

    private static Set<RussianBook> returnSetOfRussianBooks() {
        Set<RussianBook> books = new HashSet<>();
        EducationalBookFactory eduBookFactory = new EducationalBookFactory();
        FictionBookFactory fictionBookFactory = new FictionBookFactory();
        for (int i = 0; i < 60; i++) {
            books.add(random.nextBoolean() ? fictionBookFactory.createRussianBook() :
                    eduBookFactory.createRussianBook());
        }
        return books;
    }

    private static List<User> returnListOfUsers(int numberOfUsers) {
        List<User> users = new ArrayList<>();
        UserFactory userFactory = new UserFactory();
        for (int i = 0; i < numberOfUsers; i++) {
            users.add(random.nextBoolean() ? userFactory .createUser("Teacher") :
                    userFactory.createUser("Student"));
        }
        return users;
    }

    public static User[] generateUsers(int numberOfUsers) {
        List<User> listOfUsers = returnListOfUsers(numberOfUsers);
        User[] users = new User[numberOfUsers];
        for (int i = 0; i < numberOfUsers; i++) {
            users[i] = listOfUsers.get(i);
        }
        distributeBooks(users);
        return users;
    }

    private static void distributeBooks(User[] users) {
        List<EnglishBook> englishBooks = new ArrayList<>(returnSetOfEnglishBooks());
        List<RussianBook> russianBooks = new ArrayList<>(returnSetOfRussianBooks());
        for (User user : users) {
            int numberOfBooks = random.nextInt(3, 11);
            int item;
            for (int j = 0; j < numberOfBooks; j++) {
                if (random.nextBoolean()) {
                    do {
                        item = random.nextInt(englishBooks.size());
                    } while (user.isEnglishBookInList(englishBooks.get(item)));
                    user.englishBooks.add(englishBooks.get(item));
                } else {
                    do {
                        item = random.nextInt(russianBooks.size());
                    } while (user.isRussianBookInList(russianBooks.get(item)));
                    user.russianBooks.add(russianBooks.get(item));
                }
            }
        }
    }
}
