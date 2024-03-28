package Lab1.Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StudentNameGenerator {
    private static final String NAMES_FILE_PATH = System.getProperty("user.dir") + "/src/Lab1/names1.csv";
    private static final String SURNAMES_FILE_PATH = System.getProperty("user.dir") + "/src/Lab1/surnames.csv";

    public static List<String> returnStudentNames() {
        List<String> studentNames = null;
        try {
            List<String> names = CSVDataReader.readDataFromCSV(NAMES_FILE_PATH,  true, false, true);
            List<String> surnames = CSVDataReader.readDataFromCSV(SURNAMES_FILE_PATH, false, true, false);
            studentNames = generateStudentNames(names, surnames, 30);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return studentNames;
    }

    public static List<String> generateStudentNames(List<String> names, List<String> surnames, int count) {
        if (names.size() == 0 || surnames.size() == 0 || count <= 0) {
            throw new IllegalArgumentException("Invalid input data or count");
        }

        List<String> studentNames = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            int nameIndex = random.nextInt(names.size());
            String name = names.get(nameIndex);
            String surname = surnames.get(random.nextInt(surnames.size()));
            try {
                if(CSVDataReader.getGender(NAMES_FILE_PATH, nameIndex).equals("M")){
                    studentNames.add(name + " " + surname);
                } else {
                    studentNames.add(name + " " + surname+ "а");
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return studentNames;
    }
}