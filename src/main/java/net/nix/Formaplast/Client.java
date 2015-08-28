package net.nix.Formaplast;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import com.gargoylesoftware.htmlunit.html.HtmlTableRow;
import com.gargoylesoftware.htmlunit.util.Cookie;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;


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
