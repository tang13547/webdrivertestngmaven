package com.youe.cd.test.util.action;

import com.youe.cd.test.pageobject.home.BusinessPage;
import com.youe.cd.test.pageobject.home.HomePage;
import com.youe.cd.test.util.config.Config;
import org.openqa.selenium.By;

//import static com.youe.cd.test.controller.TestBase.driver;

public class WebTestDaaS extends WebTest {
    static HomePage homePage = new HomePage();
    static BusinessPage businessPage = new BusinessPage();


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

    public static void goToDataSourceManagementPage() throws Exception {
        try {
            //HomePage homePage = new HomePage();

            //driver.findElement(By.xpath("//*[@id='115']")).click();
            //homePage.getDataAccessIconElement(driver).click();
            homePage.getElement("dataAccessIcon").click();
            Thread.sleep(3000);

            //2driver.findElement(By.linkText("数据接入")).click();
            businessPage.getElement("dataAccessLink").click();
            Thread.sleep(3000);
            //2driver.findElement(By.xpath("//*[contains(text(),'数据源管理')]")).click();
            businessPage.getElement("dataSourceManagement").click();
            Thread.sleep(3000);
        } catch (Exception e) {
            logger.error("异常信息为：", e);
            throw e;
        }

    }

    public static void goToTaskManagementPage() throws Exception {
        try {
            //HomePage homePage = new HomePage();

            //driver.findElement(By.xpath("//*[@id='115']")).click();
            //homePage.getDataAccessIconElement(driver).click();
            homePage.getElement("dataAccessIcon").click();
            Thread.sleep(3000);

            //driver.findElement(By.linkText("数据接入")).click();
            businessPage.getElement("dataAccessLink").click();
            Thread.sleep(3000); //重要
            //driver.findElement(By.xpath("//li[contains(text(),'接入任务管理')]")).click();
            businessPage.getElement("accessTaskManagement").click();
            Thread.sleep(5000);
        } catch (Exception e) {
            logger.error("异常信息为：", e);
            throw e;
        }

    }

    public static void goToMetaManagementEditPageViewData(String dataSetName)  throws Exception {
        try {
            Thread.sleep(90000);
            //2driver.findElement(By.xpath("//a[contains(text(),'数据存储')]")).click();
            businessPage.getElement("dataStorage").click();
            Thread.sleep(1000);
            //2driver.findElement(By.xpath("//li[contains(text(),'元数据管理')]")).click();
            businessPage.getElement("metaDataManagement").click();
            Thread.sleep(5000);
            //Actions a = new Actions(driver);
            //a.moveToElement(driver.findElement(By.xpath("//span[text()='" + dataSetName + "']/../../../../td[9]/div/div/span"))).perform();
            //2driver.findElement(By.xpath("//span[text()='" + dataSetName + "']/../../../../td[9]/div/div/span")).click();
            ElementAction.clickBySpanTextWithExternalPath(dataSetName, "../../../../td[9]/div/div/span");
            Thread.sleep(1000);
            //2driver.findElement(By.xpath("//ul[not(contains(@style,'display: none'))]/li[contains(text(),'编辑')]")).click(); //注意编辑部分有多余空字符，所以要用contains
            businessPage.getElement("metaDataEdit").click();
            Thread.sleep(3000);
            //2driver.findElement(By.xpath("//div[text()='数据查看']")).click();
            businessPage.getElement("metaDataView").click();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            logger.error("异常信息为：", e);
            throw e;
        } catch (Exception e) {
            logger.error("异常信息为：", e);
            throw e;
        }
    }

}
