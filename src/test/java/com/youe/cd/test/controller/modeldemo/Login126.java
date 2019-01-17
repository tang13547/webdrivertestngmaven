package com.youe.cd.test.controller.modeldemo;

import com.youe.cd.test.util.config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Login126 {
    public static void main(String[] args)  throws InterruptedException {
        System.out.println("126 mail login.");

        System.setProperty("webdriver.chrome.driver", Config.chromedriverPath);
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.126.com");
        Thread.sleep(3000);

        //切换到iframe表单中，126邮箱特别注意
        //driver.switchTo().frame(0);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe")));

        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("username");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("password");
        driver.findElement(By.xpath(".//*[@id='dologin']")).click();

        driver.quit();
    }
}
