import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.util.Cookie;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Set;

/**
 * Created by fantsay on 8/7/15.
 */
public class Client {
    WebClient webClient = new WebClient(BrowserVersion.FIREFOX_38);
//    WebClientOptions opt = new WebClientOptions();

    URL site;
    URL search;
    public void getPage(String page) throws IOException {
//
//        opt.setCssEnabled(true);
//        opt.setJavaScriptEnabled(true);
//        opt.setRedirectEnabled(true);

        try {
            site = new URL("http://www.fps-catalog.com.ua/");
            search =new URL("http://www.fps-catalog.com.ua/m_sc/search_repl.php");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        CookieManager manager =  webClient.getCookieManager();
        manager.setCookiesEnabled(true);
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setRedirectEnabled(true);
        webClient.getCookieManager().
       // webClient.setCookieManager(manager);
        Set<Cookie> cookies = webClient.getCookies(site);
        WebRequest reqGet = new WebRequest(site);
        reqGet.setHttpMethod(HttpMethod.GET);
        WebRequest reqPost = new WebRequest(search);
        reqPost.setHttpMethod(HttpMethod.POST);

        //request.setRequestBody("eve=&id=%23scode_item&p1=5427AGNBL1C");
        webClient.getPage(site);
        System.out.println(cookies.isEmpty());
        System.out.println(cookies.toString());






//        DomElement elem =plast.getElementById("m_sc");
       // HtmlPage pg = elem.click();
//        System.out.println(pg.getBody());



    }


}
