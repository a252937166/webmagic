package us.codecraft.webmagic.downloader;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import us.codecraft.webmagic.downloader.selenium.WebDriverPool;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author code4crafter@gmail.com <br>
 * Date: 13-7-26 <br>
 * Time: 下午12:27 <br>
 */
public class SeleniumTest {

    @Ignore("need chrome driver")
    @Test
    public void testSelenium() {

        System.getProperties().setProperty("webdriver.chrome.driver", "/Users/Ouyang/Documents/myProjects/chromedriver");
        Map<String, Object> contentSettings = new HashMap<String, Object>();
        contentSettings.put("images", 2);
        Map<String, Object> preferences = new HashMap<String, Object>();
        preferences.put("profile.default_content_settings", contentSettings);
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setJavascriptEnabled(false);
        caps.setCapability("chrome.prefs", preferences);

        WebDriver webDriver = null;
        try {
            webDriver = new WebDriverPool(10).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        webDriver.get("http://manhua.fzdm.com/56/249/");
        WebElement webElement = webDriver.findElement(By.xpath("/html"));
        System.out.println(webElement.getAttribute("outerHTML"));
        webDriver.close();
    }
}
