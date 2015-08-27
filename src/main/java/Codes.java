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
    FileReader file;
    BufferedReader reader;
    List<String> codes;
    Iterator<String> iterator;


    public Codes(String path)
    {
        try {
            file = new FileReader(path);
            reader = new BufferedReader(file);
            codes = new LinkedList<String>();
            this.upload();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public String getCode()
    {

  if (iterator.hasNext())
        return iterator.next();

    return "Empty";
    }

    public boolean hasNext()
    {
        return iterator.hasNext();
    }


    private void upload()
    {
        String currCode;
        try {
            while ((currCode=reader.readLine())!=null)
            {
                codes.add(currCode);
            }
            iterator = codes.iterator();

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(reader!=null) try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
