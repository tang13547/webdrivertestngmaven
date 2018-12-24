package com.youe.cd.test.controller.modeldemo;

import com.youe.cd.test.util.config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class Upfile {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("srart selenium");

        System.setProperty("webdriver.chrome.driver", Config.chromedriverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments(new String[]{"-test-type"}); //去掉Chrome上的yellow alarm
        options.addArguments(new String[]{"-start-maximized"}); //最大化窗口
        WebDriver driver = new ChromeDriver(options);

        File file = new File("src/test/resources/html//upfile.html");

        String filePath = file.getAbsolutePath();
        driver.get(filePath);
        //定位上传按钮，添加本地文件
        driver.findElement(By.name("file")).sendKeys("D:\\upload_file.txt");
        Thread.sleep(5000);

        driver.quit();        
    }
}
