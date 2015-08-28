package net.nix.Formaplast;

import java.util.HashMap;
import java.util.List;

/**
 * Created by fantsay on 8/7/15.
 */
public class PriceDB {

    private HashMap<String, List<Glass>> pair = new HashMap<String, List<Glass>>();
    private static PriceDB DB;
    private PriceDB(){};
    public  static  PriceDB getDB()
    {
    if (DB == null)
        DB = new PriceDB();
    return DB;
    }

    public void addGlass(String code, List<Glass> glass)

    {
        pair.put(code, glass);
    }

    public List<Glass> getGlass(String code)

    {
        return pair.get(code);
    }



}
