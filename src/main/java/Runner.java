import java.io.IOException;

/**
 * Created by fantsay on 8/7/15.
 */
public class Runner {
    public static void main(String[] args) {
        try {
            new Client().getPage("Bla");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
