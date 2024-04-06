package Lab1.Builder;

import Lab1.AbstractFactory.BookFactory;
import Lab1.Model.Teacher;

import java.util.Random;

public class TeacherBuilder{
    private String name;
    private String surname;
    private String patronymic;

    public TeacherBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public TeacherBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public TeacherBuilder setPatronymic(String patronymic) {
        this.patronymic = patronymic;
        return this;
    }

    public Teacher build() {
        return new Teacher(name, patronymic, surname);
    }
}
