package net.nix.Formaplast;

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


       //net.nix.Formaplast.ExcelConverter.createExel(DB.getGlass(current));




        }
    }

