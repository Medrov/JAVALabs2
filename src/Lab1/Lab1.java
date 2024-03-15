package Lab1;

import java.util.ArrayList;
import java.util.List;

public class Lab1 {
    public static void main(String[] args) {
        UniversityLibraryFactory universityLibraryFactory = new UniversityLibraryFactory();
        UserBuilder userBuilder = new UserBuilder();
        List<UserBuilder> users = new ArrayList<>();

        for (String userType : new String[]{"student", "lecturer"}) {
            userBuilder.createUser(userType);
            userBuilder.addBooks(universityLibraryFactory);
            users.add(userBuilder);
        }

        for (UserBuilder user : users) {
            System.out.println(user.getUserType() + ":");
            for (Book book : user.getBooks()) {
                System.out.println("- " + book);
            }
        }
    }
}
