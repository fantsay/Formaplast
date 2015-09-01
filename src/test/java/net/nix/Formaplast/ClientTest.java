package net.nix.Formaplast;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

/**
 * Created by fantsay on 8/31/15.
 */
public class ClientTest extends TestCase {


    public void testGetPage() throws Exception {
        Client HttpCL = new Client();
        HttpCL.getPage("http://fps-catalog.com.ua/m_sc/last_table.php", "8532AGNBL1C");
        Map<Integer, List<String>> glassArray = HttpCL.getGlassArray();
        Assert.assertFalse(glassArray.isEmpty());

    }


}