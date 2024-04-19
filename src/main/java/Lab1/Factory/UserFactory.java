package main.java.Lab1.Factory;

import main.java.Lab1.Model.Student;
import main.java.Lab1.Model.Teacher;
import main.java.Lab1.Model.User;
import main.java.Lab1.Util.CSVDataReader;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class UserFactory {
    private static UserFactory INSTANCE;
    private List<String[]> listOfNames;
    private List<String[]> listOfSurnames;
    private List<String[]> listOfTeacherSurnames;


    private UserFactory() {
        try {
            listOfTeacherSurnames = CSVDataReader.readDataFromCSV(System.getProperty("user.dir") + "/src/Lab1/Data/professor_surnames.csv");
            listOfNames = CSVDataReader.readDataFromCSV(System.getProperty("user.dir") + "/src/Lab1/Data/names.csv");
            listOfSurnames = CSVDataReader.readDataFromCSV(System.getProperty("user.dir") + "/src/Lab1/Data/surnames.csv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static UserFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UserFactory();
        }
        return INSTANCE;
    }

    public User createUser(String type) {
        return switch (type) {
            case "Teacher" -> createTeacher(listOfNames, listOfTeacherSurnames);
            case "Student" -> createStudent(listOfNames, listOfSurnames);
            default -> null;
        };
    }

    private User createTeacher(List<String[]> listOfNames, List<String[]> listOfSurnames) {
        Random r = new Random();
        String[] name = listOfNames.get(r.nextInt(listOfNames.size() - 1));
        String surname = listOfSurnames.get(r.nextInt(listOfSurnames.size() - 1))[0];
        String[] nameForPatronymics;
        String patronymics;
        do {
            nameForPatronymics = listOfNames.get(r.nextInt(listOfNames.size() - 1));
        } while (Objects.equals(nameForPatronymics[1], "F"));
        if (Objects.equals(name[1], "F")) {
            if (checkSurname(surname)) surname = surname + "а";
            patronymics = nameForPatronymics[3];
        } else patronymics = nameForPatronymics[2];
        return new Teacher(name[0], patronymics, surname);
    }

    private boolean checkSurname(String surname) {
        return !surname.endsWith("о") && !surname.endsWith("ь");
    }

    private User createStudent(List<String[]> listOfNames, List<String[]> listOfSurnames) {
        Random r = new Random();
        String[] name = listOfNames.get(r.nextInt(listOfNames.size() - 1));
        String surname = listOfSurnames.get(r.nextInt(listOfSurnames.size() - 1))[0];
        if (Objects.equals(name[1], "F")) surname = surname + "а";
        return new Student(name[0], surname);
    }
}

