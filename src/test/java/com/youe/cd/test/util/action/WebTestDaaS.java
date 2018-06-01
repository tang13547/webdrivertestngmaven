package com.youe.cd.test.util.action;

import com.youe.cd.test.pageobject.home.HomePage;
import com.youe.cd.test.util.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebTestDaaS extends WebTest {
    /**
     * goto到HomePage
     * @param
     */
    public static void goToHomePage(WebDriver driver) {
        driver.get(Config.baseUrl2);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            //e.printStackTrace();
            logger.error("异常信息为：", e);
        }

    }

    public static void goToDataSourceManagementPage(WebDriver driver) {
        try {
            HomePage homePage = new HomePage();

            //driver.findElement(By.xpath("//*[@id='115']")).click();
            //homePage.getDataAccessIconElement(driver).click();
            homePage.getElement(driver, "dataAccessIcon").click();
            Thread.sleep(3000);

            driver.findElement(By.linkText("数据接入")).click();
            //driver.findElement(By.linkText("接入管理")).click();
            driver.findElement(By.xpath("//*[contains(text(),'数据源管理')]")).click();
        } catch (Exception e) {
            logger.error("异常信息为：", e);
        }

    }

}
