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
    WebClientOptions opt = new WebClientOptions();

    URL site;
    public void getPage(String page) throws IOException {

        opt.setCssEnabled(true);
        opt.setJavaScriptEnabled(true);
        opt.setRedirectEnabled(true);

        try {
            site = new URL("http://www.fps-catalog.com.ua");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Set<Cookie> cookies = webClient.getCookies(site);
        WebRequest reqGet = new WebRequest(site);
        reqGet.setHttpMethod(HttpMethod.GET);
        WebRequest reqPost = new WebRequest(site);
        reqPost.setHttpMethod(HttpMethod.POST);
        
        //request.setRequestBody("eve=&id=%23scode_item&p1=5427AGNBL1C");



       CookieManager manager =  webClient.getCookieManager();
       manager.setCookiesEnabled(true);


        DomElement elem =plast.getElementById("m_sc");
        HtmlPage pg = elem.click();
        System.out.println(pg.getBody());



    }


}
