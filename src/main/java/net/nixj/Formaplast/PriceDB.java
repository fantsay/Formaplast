package net.nixj.Formaplast;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by fantsay on 8/7/15.
 */
public class PriceDB {

    private ConcurrentHashMap<String, List<GlassEntity>> pair = new ConcurrentHashMap<>();
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

    public ConcurrentHashMap<String, List<GlassEntity>> getBase() {
        return pair;
    }

}
