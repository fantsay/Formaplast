package net.nix.Formaplast;

import java.util.HashMap;
import java.util.List;

/**
 * Created by fantsay on 8/7/15.
 */
public class PriceDB {

    private HashMap<String, List<GlassEntity>> pair = new HashMap<String, List<GlassEntity>>();
    private static PriceDB DB;

    private PriceDB() {
    }


    public static PriceDB getDB() {
        if (DB == null)
            DB = new PriceDB();
        return DB;
    }

    public void addGlass(String code, List<GlassEntity> glases)

    {
        pair.put(code, glases);
    }

    public List<GlassEntity> getGlass(String code)

    {
        return pair.get(code);
    }

    public HashMap<String, List<GlassEntity>> getBase() {
        return pair;
    }

}
