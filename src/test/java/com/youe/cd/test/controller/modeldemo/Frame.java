package com.youe.cd.test.controller.modeldemo;

import com.youe.cd.test.util.config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class Frame {
    public static void main(String[] args) {
        System.out.println("srart selenium");

        System.setProperty("webdriver.chrome.driver", Config.chromedriverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments(new String[]{"-test-type"}); //去掉Chrome上的yellow alarm
        options.addArguments(new String[]{"-start-maximized"}); //最大化窗口
        WebDriver driver = new ChromeDriver(options);

        File file = new File("src/test/resources/html/frame.html");
        String filePath = file.getAbsolutePath();
        System.out.printf("filePath is: %s\n", filePath);
        driver.get(filePath); //打开百度页面

        //切换到iframe（id = "if"）
        driver.switchTo().frame("if");  //switchTo().frame()默认可以直接取表单的id 或name 属性
        //driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='if']"))); //如果iframe 没有可用的id 和name 属性，也可以这样

        driver.findElement(By.id("kw")).sendKeys("selenium java");
        driver.findElement(By.id("su")).click();


        driver.quit();
    }
}
