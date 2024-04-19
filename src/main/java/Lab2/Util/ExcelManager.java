
package main.java.Lab2.Util;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelManager {
    ExcelHandler handler = new ExcelHandler();

    public void Import(File file, String which, boolean a) throws IOException, FileNotFoundException, InvalidFormatException{
        Repository.getInstance().setMatrix(handler.readExcel(file,which,a));
    }

    public void Export() throws IOException{
        handler.writeExcel(Repository.getInstance().getMatrix());
    }

    public void Calculate(){
        Repository.getInstance().setParameters();
    }
}
