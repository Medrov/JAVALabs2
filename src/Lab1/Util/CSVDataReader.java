package Lab1.Util;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CSVDataReader {
    public static List<String> readDataFromCSV(String filePath, Boolean isName, Boolean isSurname, Boolean isPatronym) throws IOException {
        List<String> data = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextRecord;
            while ((nextRecord = reader.readNext()) != null) {
                // Предполагается, что каждая строка в файле CSV содержит только одно значение
                String value = null;
                if (isName) {
                    value = nextRecord[0];
                } else if (isSurname) {
                    value = nextRecord[0];
                } else if (isPatronym) {
                    if (nextRecord[1].equals("F")) {
                        value = nextRecord[2];
                    } else {
                        value = nextRecord[3];
                    }
                }
                if (value != null && !value.isEmpty()) {
                    data.add(value);
                }
            }
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
    public static String getGender(String filePath, int index) throws IOException {
        List<String> data = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextRecord;
            while ((nextRecord = reader.readNext()) != null) {
                data.add(nextRecord[1]);
            }
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return data.get(index);
    }

    public static String getPatronym(String filePath, int index, boolean isMan) throws IOException {
        List<String> data = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextRecord;
            while ((nextRecord = reader.readNext()) != null) {
                String value = null;
                if (isMan) {
                    value = nextRecord[0];
                } else {
                    value = nextRecord[1];
                }
                data.add(value);
            }
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return data.get(index);
    }

    public static List<String> getDiscipline(String filePath) throws IOException {
        List<String> data = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextRecord;
            while ((nextRecord = reader.readNext()) != null) {
                data.add(nextRecord[0]);
            }
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
}
