import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by fantsay on 8/7/15.
 */
public class Parser {

    private List<Glass> glasses;
    private Map<Integer,List<String>> glString;
    public Parser(Map<Integer,List<String>> glassString) {
        this.glString = glassString;
        this.glasses = new LinkedList<>();

    }

   public List<Glass> getGlass()
   {

    glString.values().forEach(this::getG); // For every List do getG, that returns Glass Object

    return glasses;
   }

    private void getG(List<String> strings)
    {

        Glass glass = new Glass();
        //List<String> strings = glString.get(row);
        glass.setCode(strings.get(1));
        glass.setDescription(strings.get(2));
        glass.setManufact(strings.get(3));
        glass.setQuality(strings.get(4));
        glass.setOptions(strings.get(5));
        glass.setNote(strings.get(6));
        glass.setVal(strings.get(7));
        glass.setNote(strings.get(8));
        glasses.add(glass);
//        return glasses;
    }

}
