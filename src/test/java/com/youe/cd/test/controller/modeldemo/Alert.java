package com.youe.cd.test.controller.modeldemo;

import com.youe.cd.test.util.config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Alert {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("srart selenium");

        System.setProperty("webdriver.chrome.driver", Config.chromedriverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments(new String[]{"-test-type"}); //去掉Chrome上的yellow alarm
        options.addArguments(new String[]{"-start-maximized"}); //最大化窗口
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.baidu.com/"); //打开百度页面

        //鼠标悬停相“设置”链接
        Actions action = new Actions(driver);
        action.clickAndHold(driver.findElement(By.linkText("设置"))).perform();

        //打开弹出子菜单"搜索设置"
        driver.findElement(By.className("setpref")).click();
        Thread.sleep(2000);

        //保存设置
        driver.findElement(By.className("prefpanelgo")).click();
        Thread.sleep(2000);

        String alertText = driver.switchTo().alert().getText();
        System.out.println("警告框内容：" + alertText);

        //接收弹窗
        driver.switchTo().alert().accept();
        Thread.sleep(3000);

        driver.quit();
    }
}
