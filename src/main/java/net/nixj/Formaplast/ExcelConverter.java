package net.nixj.Formaplast;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
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
        this.db = base;
        this.code = code;


    }

    public void createWB() {
        exel = new XSSFWorkbook();
        spreadsheet = exel.createSheet("FormaParts");

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
        cell1.setCellValue("Description");
        cell2.setCellValue("Manufact");
        cell3.setCellValue("Quality");
        cell4.setCellValue("Price");
        cell5.setCellValue("Value");
        cell6.setCellValue("Info");

    }

    public void addDataInCells() {
        Iterator<String> iterator1 = code.getIterator();
        while (iterator1.hasNext()) {
            String current = iterator1.next();


            List<GlassEntity> array = db.getGlass(current);
            spreadsheet.createRow(rowNumber++).createCell(0).setCellValue(current);
            Iterator<GlassEntity> iterator = array.iterator();
            while (iterator.hasNext()) {

                GlassEntity gl = iterator.next();
                XSSFRow row2 = spreadsheet.createRow(rowNumber++);

                row2.createCell(0).setCellValue(gl.getCode());
                row2.createCell(1).setCellValue(gl.getDescription());
                row2.createCell(2).setCellValue(gl.getManufact());
                row2.createCell(3).setCellValue(gl.getQuality());
                row2.createCell(4).setCellValue(gl.getPrice());
                row2.createCell(5).setCellValue(gl.getVal());
                row2.createCell(6).setCellValue(gl.getNote());

            }

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
