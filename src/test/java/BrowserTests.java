import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebClientOptions;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.javascript.host.URL;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import javax.sound.midi.Soundbank;

/**
 * Created by fantsay on 8/7/15.
 */
public class BrowserTests {
    @Test
    @Ignore
    public void homePage_Firefox() throws Exception {
        try (final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_38)) {
            final HtmlPage page = webClient.getPage("http://htmlunit.sourceforge.net");
            Assert.assertEquals("HtmlUnit - Welcome to HtmlUnit", page.getTitleText());
        }
    }

    @Test
    public void Forma() throws Exception {
        try (final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_38)) {
            final HtmlPage page = webClient.getPage("http://www.fps-catalog.com.ua/#m_sc");

            URL site = new URL();







            Assert.assertEquals("HZ", page.getTitleText());


        }

    }

}