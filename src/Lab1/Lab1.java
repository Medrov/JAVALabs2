package Lab1;

import Lab1.AbstractFactory.BookFactory;
import Lab1.AbstractFactory.EnglishBookFactory;
import Lab1.AbstractFactory.RussianBookFactory;
import Lab1.Builder.StudentBuilder;
import Lab1.Builder.TeacherBuilder;
import Lab1.Builder.UserBuilder;
import Lab1.Model.Book;
import Lab1.Model.Library;
import Lab1.Model.Student;
import Lab1.Model.Teacher;

import java.util.ArrayList;
import java.util.List;

public class Lab1 {
    public static void main(String[] args) {
        // Создание библиотеки
        Library library = new Library();

        // Создание фабрик книг
        BookFactory englishBookFactory = new EnglishBookFactory();
        BookFactory russianBookFactory = new RussianBookFactory();

        // Создание строителей пользователей
        UserBuilder studentBuilder = new StudentBuilder("John");
        UserBuilder teacherBuilder = new TeacherBuilder("Jane");

        // Создание студента и добавление книг
        studentBuilder.createUser();
        studentBuilder.addBooks(englishBookFactory);
        studentBuilder.addBooks(russianBookFactory);
        Student student = (Student) studentBuilder.getUser();

        // Создание учителя и добавление книг
        teacherBuilder.createUser();
        teacherBuilder.addBooks(englishBookFactory);
        teacherBuilder.addBooks(russianBookFactory);
        Teacher teacher = (Teacher) teacherBuilder.getUser();

        // Вывод информации о книгах у студента и учителя
        System.out.println("Student " + student + " has the following books:");
        displayBooks(student.getBooks());
        System.out.println("\nTeacher " + teacher + " has the following books:");
        displayBooks(teacher.getBooks());
    }

    // Метод для отображения информации о книгах
    public static void displayBooks(List<Book> books) {
        for (Book book : books) {
            System.out.println("Title: " + book.getTitle() + ", Language: " + book.getLanguage());
        }
    }
}

