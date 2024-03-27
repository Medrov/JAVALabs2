package Lab1.Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static Lab1.Util.NameGenderDictionary.*;

public class TeacherNameGenerator {
    private static final String NAMES_FILE_PATH = System.getProperty("user.dir") + "/src/Lab1/names.csv";
    private static final String SURNAMES_FILE_PATH = System.getProperty("user.dir") + "/src/Lab1/surnames.csv";
    private static final String PATRONYMS_FILE_PATH = System.getProperty("user.dir") + "/src/Lab1/patronyms.csv";

    public static List<String> returnTeacherNames() {
        List<String> teacherNames = null;
        try {
            teacherNames = new ArrayList<>();
            List<String> names = CSVDataReader.readDataFromCSV(NAMES_FILE_PATH);
            List<String> surnames = CSVDataReader.readDataFromCSV(SURNAMES_FILE_PATH);
            List<String> patronyms = generatePatronyms(names);
            teacherNames = generateTeacherNames(surnames, patronyms, 30);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return teacherNames;
    }

    public static List<String> generateTeacherNames(List<String> surnames, List<String> patronyms, int count) {
        List<String> teacherNames = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            String surname = surnames.get(random.nextInt(surnames.size()));
            String patronym = patronyms.get(random.nextInt(patronyms.size()));
            System.out.println(patronym);
            if(getGender(patronym.split(" ")[0])){
                surname+="а";
            }
            teacherNames.add(surname + " " + patronym);
        }

        return teacherNames;
    }

    public static List<String> generatePatronyms(List<String> names) {
        List<String> patronyms = new ArrayList<>();
        for (String name : names) {
            patronyms.add(name + " " + getName(name));
        }
        return patronyms;
    }
}
