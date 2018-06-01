package com.youe.cd.test.service.access;

import com.youe.cd.test.pageobject.access.CreateTaskPage;
import com.youe.cd.test.util.DateUtil;
import com.youe.cd.test.util.action.ElementAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccessService {
    public void createTaskFlow(WebDriver driver, String dataSourceName, String dataSetName, String taskName, String nowTimeEssential) throws Exception {
        CreateTaskPage createTaskPage = new CreateTaskPage();

        createTaskPage.getElement(driver, "addTaskButton").click();

        createTaskPage.getElement(driver, "DSTypeSelect").click();
        Thread.sleep(2000);
        ElementAction.clickBySpanTextForDS(driver, "MYSQL");
        Thread.sleep(2000);

        createTaskPage.getElement(driver, "DSName").click();
        Thread.sleep(2000);

        ElementAction.clickBySpanText(driver, dataSourceName);  //不从xml文件中读取, 特殊处理
        Thread.sleep(2000);

        createTaskPage.getElement(driver, "confirmDS").click();
        Thread.sleep(5000);

        ElementAction.clickByDivTextForChooseTable(driver, "testtable");
        //driver.findElement(By.xpath("//div[contains(text(),'baidu_tieba_20000item')]")).findElement(By.xpath("./../../td[1]/div/label/span")).click();
        Thread.sleep(5000);

        createTaskPage.getElement(driver, "BusinessGroupSelect").click();
        Thread.sleep(2000);
        ElementAction.clickBySpanText(driver, "成都优易");
        Thread.sleep(1000);

        createTaskPage.getElement(driver, "dataSetNameInput").sendKeys(dataSetName);
        Thread.sleep(3000);

        createTaskPage.getElement(driver, "nextStep").click();
        Thread.sleep(3000);


        createTaskPage.getElement(driver, "tabRulePrefix").sendKeys("tab_" + nowTimeEssential);

        createTaskPage.getElement(driver, "confirmRule").click();
        Thread.sleep(3000);

        createTaskPage.getElement(driver, "saveButton").click();
        Thread.sleep(2000);

        createTaskPage.getElement(driver, "submitButton").click();
        Thread.sleep(3000);

        createTaskPage.getElement(driver, "taskNameInput").sendKeys(taskName);

        WebElement webElement = createTaskPage.getElement(driver, "effectiveDateInput");
        webElement.clear();
        webElement.sendKeys(DateUtil.getDateLiteOnlyDay());
        Thread.sleep(3000);
        createTaskPage.getElement(driver, "effectiveDateTitle").click();
        Thread.sleep(3000);

        createTaskPage.getElement(driver, "taskCycleSelect").click();
        Thread.sleep(2000);
        ElementAction.clickBySpanText(driver, "天");
        Thread.sleep(1000);

        //createTaskPage.getElement(driver, "executeTimeInput").sendKeys(DateUtil.getAfterDate(60000));
        createTaskPage.getElement(driver, "startTimeInput").sendKeys(DateUtil.getAfterDateOnlySecondHalf(60000));

        createTaskPage.getElement(driver, "amountConfigInput").sendKeys("1");
        createTaskPage.getElement(driver, "amountConfigInput2").sendKeys("10000000");
        createTaskPage.getElement(driver, "amountUnitSelect").click();
        Thread.sleep(1000);
        ElementAction.clickBySpanText(driver, "条");
        Thread.sleep(2000);

        createTaskPage.getElement(driver, "errorSelect").click();
        Thread.sleep(3000);
        ElementAction.clickBySpanText(driver, "5");
        Thread.sleep(3000);

        createTaskPage.getElement(driver, "run").click();
        Thread.sleep(3000);

        Thread.sleep(90000);
        driver.findElement(By.xpath("//a[contains(text(),'元数据管理')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[contains(text(),'数据集管理')]")).click();
        Thread.sleep(2000);
        //Actions a = new Actions(driver);
        //a.moveToElement(driver.findElement(By.xpath("//span[text()='" + dataSetName + "']/../../../../td[9]/div/div/span"))).perform();
        driver.findElement(By.xpath("//span[text()='" + dataSetName + "']/../../../../td[9]/div/div/span")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//ul[not(contains(@style,'display: none'))]/li[contains(text(),'编辑')]")).click(); //注意编辑部分有多余空字符，所以要用contains
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[text()='数据查看']")).click();
        Thread.sleep(3000);
    }
}
