package net.nixj.Formaplast;


import net.sourceforge.htmlunit.corejs.javascript.EcmaError;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by fantsay on 8/7/15.
 */
public class Runner {
    public static void main(String[] args) {
        PriceDB DB = PriceDB.getDB();
        Client HttpCL = new Client();
        HttpCL.init();
        Codes shortCodes = new Codes("/home/fantsay/java/codes.txt");
        String current;
        Codes allCodes = new Codes(HttpCL.getAllCodes(shortCodes.getCodes(), "http://www.fps-catalog.com.ua/m_sc/search_repl.php"));
        while (allCodes.hasNext()) {
            current = allCodes.getCode();
            try {
                TimeUnit.SECONDS.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                HttpCL.getPage("http://fps-catalog.com.ua/m_sc/last_table.php", current);
                } catch (EcmaError ex) {
                //NOP
            }
            Parser parser = new Parser(HttpCL.getGlassArray());
            DB.addGlass(current, parser.getGlass());
        }


        DBToFile.save(DB.getBase());
        ExcelConverter excel = new ExcelConverter();
        excel.loadDB(PriceDB.getDB(), allCodes);
        excel.createWB();
        excel.createSheet();
        excel.addDataInCells();
        excel.writeToFile();


    }
}

