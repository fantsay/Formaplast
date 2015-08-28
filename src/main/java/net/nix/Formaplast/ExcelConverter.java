package net.nix.Formaplast;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by fantsay on 8/7/15.
 */
public class ExcelConverter {
    private XSSFWorkbook exel;
    private FileOutputStream out;
    XSSFSheet spreadsheet;
    int rowNumber = 1;
    PriceDB db;
    Codes code;


    public void loadDB(PriceDB base, Codes code) {
        this.db = base; this.code = code;


    }

    public void createWB() {
        exel = new XSSFWorkbook();
        XSSFSheet spreadsheet = exel.createSheet("FormaParts");

    }

    public void createSheet() {

        XSSFRow row = spreadsheet.createRow(0);
        XSSFCell cell = row.createCell(0);
        XSSFCell cell1 = row.createCell(1);
        XSSFCell cell2 = row.createCell(2);
        XSSFCell cell3 = row.createCell(3);
        XSSFCell cell4 = row.createCell(4);
        XSSFCell cell5 = row.createCell(5);
        XSSFCell cell6 = row.createCell(6);

        cell.setCellValue("Code");
        cell1.setCellValue("Manufacturer");
        cell2.setCellValue("Quality");
        cell3.setCellValue("Price");
        cell4.setCellValue("Note");
        cell5.setCellValue("Value");
        cell6.setCellValue("Info");

    }

    public void addDataInCells() {


        String current = code.getCode();
        XSSFRow row = spreadsheet.createRow(rowNumber);
        XSSFRow row1 = spreadsheet.createRow(rowNumber = rowNumber + 1);
        XSSFCell cell = row.createCell(0);
        cell.setCellValue("");
while (true) {

    List<Glass> array = db.getGlass(current);
    Glass gl =


    gl.getCode();
    gl.getManufact();
    gl.getQuality();
    gl.getPrice();
    gl.getOptions();
    gl.getVal();
    gl.getNote();
}




    }


    public void writeToFile() {
        try {
            out = new FileOutputStream(
                    new File("Prices.xlsx"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            exel.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
