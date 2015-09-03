package net.nixj.Formaplast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by fantsay on 8/27/15.
 */
public class Codes {
   private FileReader file;
    private BufferedReader reader;
    private List<String> codes;

    public List<String> getCodes() {
        return codes;
    }

    private List<String> shortCodes;
    private Iterator<String> iterator;


    public Codes(String path) {
        try {
            file = new FileReader(path);
            reader = new BufferedReader(file);
            codes = new LinkedList<String>();
            this.upload();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Codes(List<String> codes)
    {
        this.codes=codes;
        iterator = codes.iterator();
    }

    public String getCode() {

        if (iterator.hasNext())
            return iterator.next();

        return "0";
    }

    public void longToShortCodes()
    {
        shortCodes = new LinkedList<>();
       codes.forEach(s ->shortCodes.add(s.substring(0,4)));

    }


    public boolean hasNext() {
        return iterator.hasNext();
    }

    public Iterator<String> getIterator() {
        return codes.iterator();
    }

    private void upload() {
        String currCode;
        try {
            while ((currCode = reader.readLine()) != null) {

                if (!currCode.isEmpty())
                    codes.add(currCode);
            }
            iterator = codes.iterator();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
