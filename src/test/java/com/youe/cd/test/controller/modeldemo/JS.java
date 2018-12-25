package com.youe.cd.test.controller.modeldemo;

import com.youe.cd.test.util.config.Config;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class JS {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("srart selenium");

        System.setProperty("webdriver.chrome.driver", Config.chromedriverPath);
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        /*driver.manage().window().setSize(new Dimension(480, 800));

        driver.get("http://www.baidu.com/"); //打开百度页面

        driver.findElement(By.id("kw")).sendKeys("selenium");
        driver.findElement(By.id("su")).click();
        Thread.sleep(2000);

        //将页面滚动条拖到某一位置
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(100,450);");
        Thread.sleep(3000);

        System.out.println("end");*/

        //第二个演示：
        File file = new File("src/test/resources/html/js.html");
        String filePath = file.getAbsolutePath();
        driver.get(filePath);
        Thread.sleep(1000);

        System.out.println("readyState is: " + ((JavascriptExecutor)driver).executeScript("return document.readyState").toString());

        ((JavascriptExecutor)driver).executeScript("alert(\"This is your js alert!\")");
        Thread.sleep(3000);

        // 在页面上直接执行js
        //((JavascriptExecutor)driver).executeScript("$('#tooltip').fadeOut();");
        //Thread.sleep(1000);
        // 在已经定位的元素上执行js
        /*WebElement button = driver.findElement(By.className("btn"));
        ((JavascriptExecutor)driver).executeScript("$(arguments[0]).fadeOut();", button);
        Thread.sleep(1000);
        System.out.println("browser will be close");*/

        driver.quit();
    }
}
