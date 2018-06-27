package com.youe.cd.test.util.action;

import com.youe.cd.test.pageobject.home.HomePage;
import com.youe.cd.test.util.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//import static com.youe.cd.test.controller.TestBase.driver;

public class WebTestDaaS extends WebTest {
    /**
     * goto到HomePage
     * @param
     */
    public static void goToHomePage() {
        driver.get(Config.baseUrl2);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            //e.printStackTrace();
            logger.error("异常信息为：", e);
        }

    }

    public static void goToDataSourceManagementPage() {
        try {
            HomePage homePage = new HomePage();

            //driver.findElement(By.xpath("//*[@id='115']")).click();
            //homePage.getDataAccessIconElement(driver).click();
            homePage.getElement("dataAccessIcon").click();
            Thread.sleep(3000);

            driver.findElement(By.linkText("数据接入")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//*[contains(text(),'数据源管理')]")).click();
            Thread.sleep(3000);
        } catch (Exception e) {
            logger.error("异常信息为：", e);
        }

    }

    public static void goToTaskManagementPage() {
        try {
            HomePage homePage = new HomePage();

            //driver.findElement(By.xpath("//*[@id='115']")).click();
            //homePage.getDataAccessIconElement(driver).click();
            homePage.getElement("dataAccessIcon").click();
            Thread.sleep(3000);

            driver.findElement(By.linkText("数据接入")).click();
            Thread.sleep(3000); //重要
            driver.findElement(By.xpath("//li[contains(text(),'接入任务管理')]")).click();
            Thread.sleep(3000);
        } catch (Exception e) {
            logger.error("异常信息为：", e);
        }

    }

    public static void goToMetaManagementEditPageViewData(String dataSetName)  throws Exception {
        try {
            Thread.sleep(90000);
            driver.findElement(By.xpath("//a[contains(text(),'数据存储')]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//li[contains(text(),'元数据管理')]")).click();
            Thread.sleep(2000);
            //Actions a = new Actions(driver);
            //a.moveToElement(driver.findElement(By.xpath("//span[text()='" + dataSetName + "']/../../../../td[9]/div/div/span"))).perform();
            driver.findElement(By.xpath("//span[text()='" + dataSetName + "']/../../../../td[9]/div/div/span")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//ul[not(contains(@style,'display: none'))]/li[contains(text(),'编辑')]")).click(); //注意编辑部分有多余空字符，所以要用contains
            Thread.sleep(3000);
            driver.findElement(By.xpath("//div[text()='数据查看']")).click();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            logger.error("异常信息为：", e);
        }
    }

}
