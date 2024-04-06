package Lab1.AbstractFactory;

import Lab1.Model.Book.EnglishBook;
import Lab1.Model.Book.Fiction.FictionEnglishBook;
import Lab1.Model.Book.Fiction.FictionRussianBook;
import Lab1.Model.Book.RussianBook;
import Lab1.Util.CSVDataReader;

import java.util.List;
import java.util.Random;

import static java.lang.Integer.parseInt;

public class FictionBookFactory implements BookFactory {

    private final List<String[]> englishFictionList;
    private final List<String[]> russianFictionList;
    private static FictionBookFactory INSTANCE;

    private FictionBookFactory() {
        russianFictionList = CSVDataReader.readDataFromCSV("Lab1/data/russian_fiction.csv", false, false, false);
        englishFictionList = CSVDataReader.readDataFromCSV("Lab1/data/english_fiction.csv", false, false, false);
    }

    public static FictionBookFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new FictionBookFactory();
        }
        return INSTANCE;
    }


    @Override
    public RussianBook createRussianBook() {
        new FictionRussianBook(null, 0, null, null);
        Random r = new Random();
        String[] bookInfo = russianFictionList.get(r.nextInt(russianFictionList.size() - 1));
        return new FictionRussianBook(bookInfo[0], r.nextInt(3) + 1, bookInfo[1], bookInfo[2]);
    }

    @Override
    public EnglishBook createEnglishBook() {
        new FictionEnglishBook(null, 0, null, null);
        Random r = new Random();
        String[] levels = {
                "A1", "A2", "B1", "B2", "C1", "C2"
        };
        String level = levels[r.nextInt(levels.length - 1)];
        String[] bookInfo = englishFictionList.get(r.nextInt(englishFictionList.size() - 1));
        return new FictionEnglishBook(bookInfo[0], parseInt(bookInfo[2]), bookInfo[1], level);
    }
}