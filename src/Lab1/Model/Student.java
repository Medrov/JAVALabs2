package Lab1.Model;

public class Student extends User {
    public Student(String name, String surname) {
        super(name, surname);
    }

    @Override
    public boolean isTeacher() {
        return false;
    }
}
