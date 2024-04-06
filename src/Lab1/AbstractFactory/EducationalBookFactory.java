package Lab1.AbstractFactory;


import Lab1.Model.Book.Educational.EducationalEnglishBook;
import Lab1.Model.Book.Educational.EducationalRussianBook;
import Lab1.Model.Book.EnglishBook;
import Lab1.Model.Book.RussianBook;
import Lab1.Util.CSVDataReader;

import java.util.List;
import java.util.Random;

public class EducationalBookFactory implements BookFactory {

    List<String[]> disciplinesList;
    private static EducationalBookFactory INSTANCE;

    private EducationalBookFactory() {
        disciplinesList = CSVDataReader.readDataFromCSV("Lab1/data/disciplines.csv");
    }

    public static EducationalBookFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EducationalBookFactory();
        }
        return INSTANCE;
    }

    @Override
    public RussianBook createRussianBook() {
        String[] types = {
                "Задачник", "Учебник", "Пособие"
        };
        Random r = new Random();
        String type = types[r.nextInt(types.length - 1)];
        int edition = r.nextInt(3) + 1;
        return new EducationalRussianBook(type, edition, disciplinesList.get(3)[r.nextInt(disciplinesList.get(3).length - 1)]);
    }

    @Override
    public EnglishBook createEnglishBook() {
        Random r = new Random();
        boolean isBachelor = r.nextBoolean();
        int year = r.nextInt(1950, 2024);
        String author, university, discipline;
        discipline = disciplinesList.get(0)[r.nextInt(disciplinesList.get(0).length - 1)];
        author = disciplinesList.get(1)[r.nextInt(disciplinesList.get(1).length - 1)];
        university = disciplinesList.get(2)[r.nextInt(disciplinesList.get(2).length - 1)];
        return new EducationalEnglishBook(author, year, discipline, university, isBachelor);
    }
}
