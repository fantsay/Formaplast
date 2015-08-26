import java.util.ArrayList;
import java.util.List;

/**
 * Created by s6e8 on 8/13/15.
 */
public class SerachCode {
    private String searchCode;
    private List<Glass> glass;
    SerachCode(){}

    SerachCode(String code)
    {
        glass = new ArrayList<>();
        this.searchCode=code;

    }

    public void addGlass(Glass gl)
    {
        glass.add(gl);
    }

    public List<Glass> getGlass()
    {
    return glass;
    }

}
