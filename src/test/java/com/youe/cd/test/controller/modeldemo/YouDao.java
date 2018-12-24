package com.youe.cd.test.controller.modeldemo;

import com.youe.cd.test.util.config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class YouDao {
    public static void main(String[] args) {
        System.out.println("126 mail login.");

        System.setProperty("webdriver.chrome.driver", Config.chromedriverPath);
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        driver.get("http://www.youdao.com");

        driver.findElement(By.id("translateContent")).sendKeys("submit");
        //提交输入的内容
        driver.findElement(By.id("translateContent")).submit();

        driver.quit();
    }
}
