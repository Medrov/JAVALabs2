package Lab1.Util;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CSVDataReader {
    public static List<String[]> readDataFromCSV(String filePath) throws IOException {
        List<String[]> data = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextRecord;
            while ((nextRecord = reader.readNext()) != null) {
                data.add(nextRecord);
            }
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
}
