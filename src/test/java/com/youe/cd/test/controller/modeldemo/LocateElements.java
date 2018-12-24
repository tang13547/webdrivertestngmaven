package com.youe.cd.test.controller.modeldemo;

import com.youe.cd.test.util.config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.List;

public class LocateElements {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("srart selenium");

        System.setProperty("webdriver.chrome.driver", Config.chromedriverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments(new String[]{"-test-type"}); //去掉Chrome上的yellow alarm
        options.addArguments(new String[]{"-start-maximized"}); //最大化窗口
        WebDriver driver = new ChromeDriver(options);

        File file = new File("src/test/resources/html/checkbox.html");
        String filePath = file.getAbsolutePath();

        driver.get(filePath); //打开页面

        List<WebElement> inputs = driver.findElements(By.tagName("input"));
        for (WebElement checkbox : inputs) {
            String type = new String(checkbox.getAttribute("type"));
            if (type.equals("checkbox")) {
                checkbox.click();
                Thread.sleep(2000);
            }
        }

        driver.quit();
    }
}
