package Lab1.Model;

public class Teacher extends User {
    private final String patronymic;

    public Teacher(String name, String patronymic, String surname) {
        super(name, surname);
        this.patronymic = patronymic;
    }
    public String getString() {
        return name + " " + patronymic + " " + surname;
    }

    @Override
    public boolean isTeacher() {
        return true;
    }
}
