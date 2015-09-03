package net.nixj.Formaplast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by fantsay on 8/31/15.
 */
public class DBToFile {

    public static void save(ConcurrentHashMap<String, List<GlassEntity>> map) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("PriceDB.ser");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            oos.writeObject(map);

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
