import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import com.gargoylesoftware.htmlunit.html.HtmlTableRow;
import com.gargoylesoftware.htmlunit.util.Cookie;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

/**
 * Created by fantsay on 8/7/15.
 */
public class Client {
    WebClient webClient = new WebClient(BrowserVersion.INTERNET_EXPLORER_11);
    HtmlPage resultPage;
    URL site;
    public void getPage(String page,String code) {


        try {
            site = new URL(page);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        WebRequest reqGet = new WebRequest(site);
        reqGet.setHttpMethod(HttpMethod.GET);
        WebRequest reqPost = new WebRequest(site);
        reqPost.setHttpMethod(HttpMethod.POST);
//        reqPost.setAdditionalHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
//        reqPost.setAdditionalHeader("Host", "fps-catalog.com.ua");
//        reqPost.setAdditionalHeader("X-Requested-With", "XMLHttpRequest");
//        reqPost.setAdditionalHeader("Referer", "http://fps-catalog.com.ua/");
//        reqPost.setAdditionalHeader("Cookie", "term=694006; term=8459; PHPSESSID=1bdc8808c01604bcb16c33ae3a6454ed;  _ga=GA1.3.678498098.1438938050");

        reqPost.setRequestBody("eve=&id=%23scode_item&p1="+code);
        CookieManager manager = webClient.getCookieManager();
        manager.setCookiesEnabled(true);
        java.util.Set<Cookie> cookies = webClient.getCookieManager().getCookies();

        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.waitForBackgroundJavaScript(50000);
        try {
            resultPage = webClient.getPage(reqPost);
        } catch (IOException e) {
            e.printStackTrace();
        }
        webClient.waitForBackgroundJavaScript(50000);


        //System.out.println(row.asText());

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
    public Map<Integer,List<String>> getGlassArray()
    {
        int counter = 0;
        HtmlTable table = (HtmlTable) resultPage.getByXPath("//table[@class='k-grid-item']").get(0);
        int rowCount = table.getRowCount();// loop for rows then loop for cells in each row
        Map<Integer,List<String>> mapa = new HashMap<>();

        for (int i = 1; i<rowCount; i++) {
            List<String> glassString = new LinkedList<>();
            HtmlTableRow row = table.getRow(i);
            HtmlTableRow.CellIterator cellIterator = row.getCellIterator();


                while (cellIterator.hasNext()){
                glassString.add(cellIterator.next().asText() );


        }
            mapa.put(counter,glassString);
            counter++;
        }
        return mapa;
    }

}
