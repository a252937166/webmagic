package com.ouyanglol.start;

import com.ouyanglol.core.QuickBase;
import com.ouyanglol.crawler.ComicCrawler;
import com.ouyanglol.crawler.TestCrawler;

/**
 * Package: com.ouyanglol.start
 *
 * @Author: Ouyang
 * @Date: 2018/2/2
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        QuickBase quickBase = QuickBase.getInstance("crawler");
        ComicCrawler crawler = (ComicCrawler) quickBase.getQuick("ComicCrawler");
        crawler.start("http://hanhuazu.cc/cartoon/post?id=10444");
    }
}
