package com.youe.cd.test.controller.modeldemo;

import com.youe.cd.test.util.config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class SimpleDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("srart selenium");

        System.setProperty("webdriver.chrome.driver", Config.chromedriverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments(new String[]{"-test-type"}); //去掉Chrome上的yellow alarm
        options.addArguments(new String[]{"-start-maximized"}); //最大化窗口
        WebDriver driver = new ChromeDriver(options);

        driver.get("http://www.baidu.com/"); //打开百度页面

        driver.findElement(By.id("kw")).sendKeys("selenium java");
        Thread.sleep(3000);
        driver.findElement(By.id("su")).click();
        Thread.sleep(3000);

        //Assert.assertEquals("1", "2", "看到此条信息，证明实际值和期望值不相等");

        driver.close();
    }
}
