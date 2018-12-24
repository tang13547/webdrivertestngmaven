package com.youe.cd.test.controller.modeldemo;

import com.youe.cd.test.util.config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SimpleDemo {
    public static void main(String[] args) {
        System.out.println("srart selenium");

        System.setProperty("webdriver.chrome.driver", Config.chromedriverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments(new String[]{"-test-type"}); //去掉Chrome上的yellow alarm
        options.addArguments(new String[]{"-start-maximized"}); //最大化窗口
        WebDriver driver = new ChromeDriver(options);

        driver.get("http://www.baidu.com/"); //打开百度页面

        driver.findElement(By.id("kw")).sendKeys("selenium java");
        driver.findElement(By.id("su")).click();


        driver.close();
    }
}
