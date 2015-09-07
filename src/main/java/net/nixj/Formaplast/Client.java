package net.nixj.Formaplast;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import com.gargoylesoftware.htmlunit.html.HtmlTableRow;
import com.gargoylesoftware.htmlunit.util.Cookie;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class Client {
    WebClient webClient = new WebClient(BrowserVersion.INTERNET_EXPLORER_11);
    HtmlPage resultPage;
    URL site;
    List<String> tmpcodes = new LinkedList<>();
    int counter;
    CookieManager manager;
    List<String> missedCodes ;

  public void init()
  {
      manager = webClient.getCookieManager();
      manager.setCookiesEnabled(true);
      java.util.Set<Cookie> cookies = webClient.getCookieManager().getCookies();
      webClient.getOptions().setThrowExceptionOnScriptError(false);
  }



    public void getPage(String page, String code) {


        try {
            site = new URL(page);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        WebRequest reqGet = new WebRequest(site);
        reqGet.setHttpMethod(HttpMethod.GET);
        WebRequest reqPost = new WebRequest(site);
        reqPost.setHttpMethod(HttpMethod.POST);
        reqPost.setRequestBody("p1=" + code);
        webClient.waitForBackgroundJavaScript(50000);
        try {
            resultPage = webClient.getPage(reqPost);
        } catch (IOException e) {
            e.printStackTrace();
        }
        webClient.waitForBackgroundJavaScript(50000);

    }
   // Returns all codes that match short representation (5 chars)
    public  List<String> getAllCodes(List<String> shortCode, String site) {
        missedCodes = new LinkedList<>();
        HtmlPage resultPage1 = null;
        URL page=null;
        try {
            page = new URL(site);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        WebRequest reqPostt = new WebRequest(page);
        reqPostt.setHttpMethod(HttpMethod.POST);
        webClient.waitForBackgroundJavaScript(70000);
        Iterator<String> listOfCodesIterator= shortCode.iterator();

       while (listOfCodesIterator.hasNext()) {
           String next = listOfCodesIterator.next();
           reqPostt.setRequestBody("p1=" + next );
           try {
               resultPage1 = webClient.getPage(reqPostt);
           } catch (IOException e) {
               e.printStackTrace();
           }
           webClient.waitForBackgroundJavaScript(70000);
           //IF captcha rerequest lastcode
           System.out.println(resultPage1.asText().length());
           if(resultPage1.asText().length()==20)
           {
               manager.clearCookies();
               missedCodes.add(next);

               continue;
           }


           try {
               TimeUnit.SECONDS.sleep(20);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           try {

               List<?> array = resultPage1.getByXPath("//table[@class='body noselect kendogrid k-grid-part']");

               if (!array.isEmpty()) {
                   System.out.println(array.size());
                   HtmlTable table = (HtmlTable)array.get(0);
                   System.out.println(table.asText());


                   System.out.println(table.asText());
                   int rowCount = table.getRowCount();

                   for (int i = 1; i < rowCount; i++) {
                       HtmlTableRow row = table.getRow(i);
                       tmpcodes.add(row.getCell(0).asText());

                   }
               }
           } catch (java.lang.IndexOutOfBoundsException ex) {

               counter++;
               ex.printStackTrace();
               System.out.println(ex.getMessage());
           }



       }
        if (!missedCodes.isEmpty())
        {
            this.getAllCodes(missedCodes,"http://www.fps-catalog.com.ua/m_sc/search_repl.php");
        }
        return tmpcodes;
    }



    public Map<Integer, List<String>> getGlassArray() {
        int counter = 0;
        HtmlTable table = (HtmlTable) resultPage.getByXPath("//table[@class='k-grid-item']").get(0);
        int rowCount = table.getRowCount();     // loop for rows then loop for cells in each row
        Map<Integer, List<String>> mapa = new HashMap<>();

        for (int i = 1; i < rowCount; i++) {
            List<String> glassString = new LinkedList<>();
            HtmlTableRow row = table.getRow(i);
            HtmlTableRow.CellIterator cellIterator = row.getCellIterator();


            while (cellIterator.hasNext()) {
                glassString.add(cellIterator.next().asText());


            }
            mapa.put(counter, glassString);
            counter++;
        }
        return mapa;
    }

}
