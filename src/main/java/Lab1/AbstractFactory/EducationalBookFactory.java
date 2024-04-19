package main.java.Lab1.AbstractFactory;


import main.java.Lab1.Model.Book.Educational.EducationalEnglishBook;
import main.java.Lab1.Model.Book.Educational.EducationalRussianBook;
import main.java.Lab1.Model.Book.EnglishBook;
import main.java.Lab1.Model.Book.RussianBook;
import main.java.Lab1.Util.CSVDataReader;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class EducationalBookFactory implements BookFactory {

    List<String[]> disciplinesList;
    private static EducationalBookFactory INSTANCE;

    private EducationalBookFactory() {
        try {
            disciplinesList = CSVDataReader.readDataFromCSV(System.getProperty("user.dir") + "/src/Lab1/Data/disciplines.csv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static EducationalBookFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EducationalBookFactory();
        }
        return INSTANCE;
    }

    @Override
    public RussianBook createRussianBook() {
        String[] types = {"Задачник", "Учебник", "Пособие"};
        Random random = new Random();
        String type = types[random.nextInt(types.length - 1)];
        int edition = random.nextInt(types.length) + 1;
        return new EducationalRussianBook(type, edition, disciplinesList.get(3)[random.nextInt(disciplinesList.get(3).length - 1)]);
    }

    @Override
    public EnglishBook createEnglishBook() {
        Random r = new Random();
        boolean isBachelor = r.nextBoolean();
        int year = r.nextInt(1950, 2025);
        String author, university, discipline;
        discipline = disciplinesList.get(0)[r.nextInt(disciplinesList.get(0).length - 1)];
        author = disciplinesList.get(1)[r.nextInt(disciplinesList.get(1).length - 1)];
        university = disciplinesList.get(2)[r.nextInt(disciplinesList.get(2).length - 1)];
        return new EducationalEnglishBook(author, year, discipline, university, isBachelor);
    }
}
