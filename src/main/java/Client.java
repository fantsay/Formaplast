import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.*;
import com.gargoylesoftware.htmlunit.httpclient.HtmlUnitBrowserCompatCookieSpec;
import com.gargoylesoftware.htmlunit.javascript.host.dom.Document;
import com.gargoylesoftware.htmlunit.javascript.host.dom.Node;
import com.gargoylesoftware.htmlunit.javascript.host.xml.XMLDocument;
import com.gargoylesoftware.htmlunit.util.Cookie;
import jdk.nashorn.internal.parser.JSONParser;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by fantsay on 8/7/15.
 */
public class Client {
    WebClient webClient = new WebClient(BrowserVersion.INTERNET_EXPLORER_11);
    Map<String,Map<String,String>> db = new HashMap<>();


    URL site;
    public void getPage(String page) throws IOException {



        try {
            site = new URL("http://fps-catalog.com.ua/m_sc/last_table.php");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        WebRequest reqGet = new WebRequest(site);
        reqGet.setHttpMethod(HttpMethod.GET);
        WebRequest reqPost = new WebRequest(site);
        reqPost.setHttpMethod(HttpMethod.POST);
        reqPost.setAdditionalHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        reqPost.setAdditionalHeader("Host","fps-catalog.com.ua");
        reqPost.setAdditionalHeader("X-Requested-With","XMLHttpRequest");
        reqPost.setAdditionalHeader("Referer","http://fps-catalog.com.ua/");
        reqPost.setAdditionalHeader("Cookie","term=182181; PHPSESSID=c40f8e42df5f6ea71fcae2918ecc7e5c; term=546417; _ga=GA1.3.1070382118.1439109851");
        //reqPost.setAdditionalHeader("","");
        reqPost.setRequestBody("eve=&id=%23scode_item&p1=5427AGNBL1C");

        reqPost.setUrl(site);

//        request.setRequestBody("eve=&id=%23scode_item&p1=5427AGNBL1C");



       CookieManager manager =  webClient.getCookieManager();
       manager.setCookiesEnabled(true);
//        HtmlPage main = webClient.getPage(reqGet);
        java.util.Set<Cookie> cookies = webClient.getCookieManager().getCookies();

     webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.waitForBackgroundJavaScript(50000);
        HtmlPage page1 = webClient.getPage(reqPost);
        webClient.waitForBackgroundJavaScript(50000);
        HtmlTable table = (HtmlTable) page1.getByXPath("//table[@class='k-grid-item']").get(0);
        table.getRowCount(); // loop for rows then loop for cells in each row

        HtmlTableRow row = table.getRow(1);
        HtmlTableRow.CellIterator cellIterator = row.getCellIterator();
        while (cellIterator.hasNext())
        {
            cellIterator.next().asText();

        }
//        System.out.println(row.asText());

//        DomNodeList<DomElement> td = page1.getElementsByTagName("td");
//        DomElement domElement = td.get(10);
//        System.out.println(domElement.asText());
        //System.out.print(page1.getElementsByTagName("td"));

//        String doc = page1.asXml();
//        doc.replace("")
//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        try {
//            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
//            org.w3c.dom.Document docu = documentBuilder.parse(new InputSource(new StringReader(doc)));
//            System.out.println(docu.);
//
//
//        } catch (ParserConfigurationException e) {
//            e.printStackTrace();
//        } catch (SAXException e) {
//            e.printStackTrace();
//        }


//        DomElement input = page1.getElementById("search_by_code");
//        input.setAttribute("value","3003AGN");

// Map<String, DomAttr> attributesMap = input.getAttributesMap();
//        System.out.println(input.asText());
//        attributesMap.keySet().iterator().forEachRemaining(System.out::println);
//        HtmlPage result = p
//        WebResponse response = page1.getElementById("search").click().getWebResponse();
//        System.out.println(response.getContentAsString());
//
//        webClient.waitForBackgroundJavaScript(50000);
//       result.getElementsByName("td").iterator().forEachRemaining(System.out::println);


//        String xml = result.asXml();





    }


}
