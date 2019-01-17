package com.youe.cd.test.controller.modeldemo;

import com.youe.cd.test.util.config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Timeout {
    public static void main(String[] args) {
        System.out.println("srart selenium");

        System.setProperty("webdriver.chrome.driver", Config.chromedriverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments(new String[]{"-test-type"}); //去掉Chrome上的yellow alarm
        options.addArguments(new String[]{"-start-maximized"}); //最大化窗口
        WebDriver driver = new ChromeDriver(options);

        //页面加载超时时间设置为5s
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

        driver.get("http://www.baidu.com/"); //打开百度页面

        //定位对象时给10s 的时间, 如果10s 内还定位不到则抛出异常
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("kw33")).sendKeys("selenium");

        //异步脚本的超时时间设置成3s
        driver.manage().timeouts().setScriptTimeout(3, TimeUnit.SECONDS);

        driver.quit();
    }
}
