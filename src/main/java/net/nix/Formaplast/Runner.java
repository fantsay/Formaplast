package net.nix.Formaplast;


import java.util.concurrent.TimeUnit;

/**
 * Created by fantsay on 8/7/15.
 */
public class Runner {
    public static void main(String[] args) {
        PriceDB DB = PriceDB.getDB();
        Client HttpCL = new Client();
        Codes codes = new Codes("/home/fantsay/java/codes.txt");
        String current;
        while (codes.hasNext()) {
            current = codes.getCode();
            try {
                TimeUnit.SECONDS.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                HttpCL.getPage("http://fps-catalog.com.ua/m_sc/last_table.php", current);
            } catch (net.sourceforge.htmlunit.corejs.javascript.EcmaError ex) {
                //NOP
            }
            Parser parser = new Parser(HttpCL.getGlassArray());
            DB.addGlass(current, parser.getGlass());
        }


        DBToFile.save(DB.getBase());
        ExcelConverter exel = new ExcelConverter();
        exel.loadDB(PriceDB.getDB(), codes);
        exel.createWB();
        exel.createSheet();
        exel.addDataInCells();
        exel.writeToFile();


    }
}

