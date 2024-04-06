package Lab1.Builder;

import Lab1.AbstractFactory.BookFactory;
import Lab1.Model.Student;

import java.util.Random;

public class StudentBuilder {
    private String name;
    private String surname;

    public StudentBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public StudentBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public Student build() {
        return new Student(name, surname);
    }
}
