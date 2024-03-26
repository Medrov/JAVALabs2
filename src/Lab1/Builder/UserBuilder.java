package Lab1.Builder;

import Lab1.AbstractFactory.BookFactory;
import Lab1.Model.User;

public abstract class UserBuilder {
    protected String name;
    protected User user;

    public UserBuilder(String name) {
        this.name = name;
    }

    public abstract void createUser();

    public abstract void addBooks(BookFactory bookFactory);

    public User getUser() {
        return user;
    }
}
