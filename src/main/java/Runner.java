import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

/**
 * Created by fantsay on 8/7/15.
 */
public class Runner {
    public static void main(String[] args) {
        PriceDB DB = PriceDB.getDB();
        Client HttpCL = new Client();
        Codes codes = new Codes("/home/fantsay/java/codes.txt");
        String current;
        while(codes.hasNext()) {
            current = codes.getCode();
            HttpCL.getPage("http://fps-catalog.com.ua/m_sc/last_table.php", current);
            Parser parser = new Parser(HttpCL.getGlassArray());
            DB.addGlass(current, parser.getGlass());
        }

        //parser.getGlass().iterator().forEachRemaining(System.out::println);


       //ExcelConverter.createExel(DB.getGlass(current));




        }
    }

