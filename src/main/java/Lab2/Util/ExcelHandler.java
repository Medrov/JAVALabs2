package main.java.Lab2.Util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.*;


public class ExcelHandler {

    public double[][] readExcel(File file, String which, boolean a) throws IOException, InvalidFormatException {
        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(file);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении Excel файла: " + e.getMessage());
            return null;
        }

        Sheet sheet;
        if (a) {
            try {
                int index = Integer.parseInt(which) - 1;
                sheet = workbook.getSheetAt(index);
            } catch (IllegalArgumentException e) {
                System.out.println("Неверный формат индекса листа. Используется первый лист.");
                sheet = workbook.getSheetAt(0);
            }
        } else {
            sheet = workbook.getSheet(which);
        }

        if (sheet == null) {
            System.out.println("Лист не найден, используется первый лист.");
            sheet = workbook.getSheetAt(0);
        }

        int numRows = sheet.getPhysicalNumberOfRows();
        int numCols = 0;
        for (int i = 0; i < numRows; i++) {
            numCols = Math.max(numCols, sheet.getRow(i).getLastCellNum());
        }

        double[][] data = new double[numCols][numRows];
        for (int i = 0; i < numRows; i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                for (int j = 0; j < numCols; j++) {
                    Cell cell = row.getCell(j);
                    if (cell != null && cell.getCellType() == CellType.NUMERIC) {
                        data[j][i] = cell.getNumericCellValue();
                    }
                }
            }
        }

        workbook.close();
        return data;
    }

    public void writeExcel(double[][] mas) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Полученные значения");
        // Запись данных в таблицу
        // (пропущено для краткости)
        try (FileOutputStream fileOut = new FileOutputStream("краб.xlsx")) {
            workbook.write(fileOut);
            System.out.println("Параметры успешно экспортированы");
        } catch (IOException e) {
            System.out.println("Ошибка экспорта параметров: " + e.getMessage());
        } finally {
            workbook.close();
        }
    }
}
