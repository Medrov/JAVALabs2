package Lab1.Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class TeacherNameGenerator {
    private static final String NAMES_FILE_PATH = System.getProperty("user.dir") + "/src/Lab1/names1.csv";
    private static final String SURNAMES_FILE_PATH = System.getProperty("user.dir") + "/src/Lab1/surnames.csv";
    private static final String PATRONYMS_FILE_PATH = System.getProperty("user.dir") + "/src/Lab1/patronyms.csv";

    public static List<String> returnTeacherNames() {
        List<String> teacherNames = null;
        try {
            teacherNames = new ArrayList<>();
            List<String> names = CSVDataReader.readDataFromCSV(NAMES_FILE_PATH, true, false, true);
            List<String> surnames = CSVDataReader.readDataFromCSV(SURNAMES_FILE_PATH, true, false, false);
            generateTeacherNames(names, surnames, 30);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return teacherNames;
    }

    public static List<String> generateTeacherNames(List<String> names, List<String> surnames, int count) {
        List<String> teacherNames = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            int nameIndex = random.nextInt(names.size());
            String name = names.get(nameIndex);
            String surname = surnames.get(random.nextInt(surnames.size()));
            String patronym = null;

            try {
                if(CSVDataReader.getGender(NAMES_FILE_PATH, nameIndex).equals("M")){
                    patronym = CSVDataReader.getPatronym(PATRONYMS_FILE_PATH, nameIndex, true);
                    teacherNames.add(name+" "+ patronym + " " + surname);
                } else {
                    patronym = CSVDataReader.getPatronym(PATRONYMS_FILE_PATH, nameIndex, false);
                    teacherNames.add(name+" "+ patronym + " " + surname+ "а");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        System.out.println(teacherNames);
        return teacherNames;
    }

    public static List<String> generatePatronyms(List<String> names) {
        List<String> patronyms = new ArrayList<>();
        for (String name : names) {
            patronyms.add(name + " ");
        }
        return patronyms;
    }
}
