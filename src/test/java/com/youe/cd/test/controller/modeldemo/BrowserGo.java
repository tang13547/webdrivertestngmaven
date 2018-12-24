package com.youe.cd.test.controller.modeldemo;

import com.youe.cd.test.util.config.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserGo {
    public static void main(String[] args) {
        System.out.println("srart selenium");

        System.setProperty("webdriver.chrome.driver", Config.chromedriverPath);
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        String firstUrl = "http://www.baidu.com";
        String secodUrl = "http://news.baidu.com";

        driver.get(firstUrl); //打开第一个页面
        driver.get(secodUrl); //打开第二个页面

        driver.navigate().back(); //后退
        driver.navigate().forward(); //前进

        driver.quit();
    }
}
