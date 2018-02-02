package com.ouyanglol.crawler;

import com.ouyanglol.annotation.QuickSpring;
import com.ouyanglol.service.TestService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import us.codecraft.webmagic.downloader.selenium.WebDriverPool;

/**
 * Package: com.ouyanglol.crawler
 *
 * @Author: Ouyang
 * @Date: 2018/2/2
 */
@QuickSpring
public class TestCrawler {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    TestService testService;

    public void test() {
        logger.info("这是{}",getClass().getName());
        testService.test();

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
