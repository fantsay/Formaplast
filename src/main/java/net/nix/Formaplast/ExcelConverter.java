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


    public void loadDB()
{

}

public void createWB()
{
    exel = new XSSFWorkbook();
    XSSFSheet spreadsheet = exel.createSheet("FormaParts");
}

public void createExel(List<Glass> glasses)
{

    XSSFRow row = spreadsheet.createRow(0);
    XSSFCell cell = row.createCell(0);
    XSSFCell cell1 = row.createCell(1);
    XSSFCell cell2 = row.createCell(2);
    cell.setCellValue("Code");
    cell1.setCellValue("Description");
    cell2.setCellValue("Price");
    XSSFRow row1 = spreadsheet.createRow(1);
    XSSFCell cell1_0 = row1.createCell(0);
    XSSFCell cell1_1 = row1.createCell(1);
    XSSFCell cell1_2 = row1.createCell(2);


    cell1_0.setCellValue(glasses.iterator().next().getCode());


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
