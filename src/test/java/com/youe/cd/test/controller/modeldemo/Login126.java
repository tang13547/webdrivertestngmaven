package com.youe.cd.test.controller.modeldemo;

import com.youe.cd.test.util.config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Login126 {
    public static void main(String[] args) {
        System.out.println("126 mail login.");

        System.setProperty("webdriver.chrome.driver", Config.chromedriverPath);
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        driver.get("http://www.126.com");

        driver.findElement(By.id("idInput")).clear();
        driver.findElement(By.id("idInput")).sendKeys("username");
        driver.findElement(By.id("pwdInput")).clear();
        driver.findElement(By.id("pwdInput")).sendKeys("password");
        driver.findElement(By.id("loginBtn")).click();

        driver.quit();
    }
}
