package com.ouyanglol.crawler;

import com.ouyanglol.annotation.QuickSpring;
import com.ouyanglol.service.ComicBasicService;
import com.ouyanglol.service.ComicChapterService;
import com.ouyanglol.service.ComicContentService;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import us.codecraft.webmagic.downloader.selenium.WebDriverPool;

import java.util.List;

/**
 * Package: com.ouyanglol.crawler
 *
 * @Author: Ouyang
 * @Date: 2018/2/2
 */
@QuickSpring
public class ComicCrawler {
    @Autowired
    ComicBasicService comicBasicService;
    @Autowired
    ComicChapterService comicChapterService;
    @Autowired
    ComicContentService comicContentService;
    private WebDriverPool webDriverPool = new WebDriverPool(10);

    public void start(String url) throws InterruptedException {
        WebDriver webDriver = webDriverPool.get();
        webDriver.get(url);
        JavascriptExecutor driver_js= (JavascriptExecutor) webDriver;
        driver_js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        List<WebElement> elements =  webDriver.findElements(By.className("img-wp"));
        for (WebElement element : elements) {
            String imgUrl = element.findElement(By.tagName("img")).getAttribute("src");
            System.out.println(imgUrl);
        }
    }
}
