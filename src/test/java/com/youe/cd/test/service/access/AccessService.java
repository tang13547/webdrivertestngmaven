package com.youe.cd.test.service.access;

import com.youe.cd.test.pageobject.access.CreateTaskPage;
import com.youe.cd.test.util.DateUtil;
import com.youe.cd.test.util.action.ElementAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.youe.cd.test.controller.TestBase.driver;

public class AccessService {
    CreateTaskPage createTaskPage = new CreateTaskPage();

    /**
     * 创建任务流程，默认for mysql
     * @param
     * @param dataSourceName
     * @param dataSetName
     * @param
     * @param tabRulePrefix
     * @throws Exception
     */
    public void createTaskFlow(String dataSourceName, String dataSetName,String testtable, String tabRulePrefix) throws Exception {
        //CreateTaskPage createTaskPage = new CreateTaskPage();

        createTaskPage.getElement("addTaskButton").click();

        createTaskPage.getElement("DSTypeSelect").click();
        Thread.sleep(2000);
        ElementAction.clickBySpanText("MYSQL");
        Thread.sleep(2000);

        createTaskPage.getElement("DSName").click();
        Thread.sleep(2000);

        ElementAction.clickBySpanText(dataSourceName);  //不从xml文件中读取, 特殊处理
        Thread.sleep(2000);

        createTaskPage.getElement("confirmDS").click();
        Thread.sleep(5000);

        ElementAction.clickByDivTextWithExternalPath(testtable, "../../td[1]");
        //driver.findElement(By.xpath("//div[contains(text(),'baidu_tieba_20000item')]")).findElement(By.xpath("./../../td[1]/div/label/span")).click();
        Thread.sleep(5000);

        createTaskPage.getElement("BusinessGroupSelect").click();
        Thread.sleep(2000);
        ElementAction.clickBySpanText("成都优易");
        Thread.sleep(1000);

        createTaskPage.getElement("dataSetNameInput").sendKeys(dataSetName);
        Thread.sleep(3000);
        createTaskPage.getElement("dataSetName").click(); //增加点击文字取消下拉提示框
        Thread.sleep(3000);

        createTaskPage.getElement("nextStep").click();
        Thread.sleep(3000);


        createTaskPage.getElement("tabRulePrefix").sendKeys(tabRulePrefix);

        createTaskPage.getElement("confirmRule").click();
        Thread.sleep(3000);

        createTaskPage.getElement("saveButton").click();
        Thread.sleep(2000);

        createTaskPage.getElement("submitButton").click();
        Thread.sleep(3000);


    }

    public void createTaskFlow(String dataSourceType, String dataSourceName, String filePath, String fileType, String colSeparator, String mediaType, String dataSetName, String tabName, String filedLength, String fieldType) throws Exception {
        //CreateTaskPage createTaskPage = new CreateTaskPage();

        createTaskPage.getElement("addTaskButton").click();

        createTaskPage.getElement("DSTypeSelect").click();
        Thread.sleep(2000);
        ElementAction.clickBySpanText(dataSourceType);  //参数如:FTP
        Thread.sleep(2000);

        createTaskPage.getElement("DSName").click();
        Thread.sleep(2000);

        ElementAction.clickBySpanText(dataSourceName);  //不从xml文件中读取, 特殊处理
        Thread.sleep(2000);

        createTaskPage.getElement("confirmDS").click();
        Thread.sleep(5000);

        //2ElementAction.clickByDivTextWithExternalPath(driver, "testtable", "../../td[1]");
        //driver.findElement(By.xpath("//div[contains(text(),'baidu_tieba_20000item')]")).findElement(By.xpath("./../../td[1]/div/label/span")).click();
        //2Thread.sleep(5000);

        createTaskPage.getElement("filePath").sendKeys(filePath); //参数如：test2/subftp
        Thread.sleep(1000);
        createTaskPage.getElement("fileTypeSelect").click();
        Thread.sleep(3000);
        ElementAction.clickBySpanText(fileType); //参数如：txt,json,csv
        Thread.sleep(2000);
        createTaskPage.getElement("colSeparator").sendKeys(colSeparator); //参数开如：,
        Thread.sleep(2000);

        //操作区选择是否包含表头
        createTaskPage.getElement("ChooseTableHeader").click();

        createTaskPage.getElement("mediaTypeSelect").click();
        Thread.sleep(2000);
        ElementAction.clickBySpanText(mediaType); //目标介质，参数如：MYSQL, HDFS
        Thread.sleep(2000);
        createTaskPage.getElement("BusinessGroupSelect").click();
        Thread.sleep(2000);
        ElementAction.clickBySpanText("成都优易");
        Thread.sleep(1000);

        createTaskPage.getElement("dataSetNameInput").sendKeys(dataSetName);
        Thread.sleep(3000);
        createTaskPage.getElement("dataSetName").click(); //增加点击文字取消下拉提示框
        Thread.sleep(3000);

        createTaskPage.getElement("nextStep").click();
        Thread.sleep(3000);

        /*createTaskPage.getElement(driver, "tabRulePrefix").sendKeys(tabRulePrefix);

        createTaskPage.getElement(driver, "confirmRule").click();
        Thread.sleep(3000);

        createTaskPage.getElement(driver, "saveButton").click();
        Thread.sleep(2000);*/

        createTaskPage.getElement("tabName").sendKeys(tabName);
        Thread.sleep(1000);
        createTaskPage.getElement("filedLength").sendKeys(filedLength); //参数如12等
        Thread.sleep(1000);
        createTaskPage.getElement("fieldTypeSelect").click();
        Thread.sleep(3000); //重要
        ElementAction.clickBySpanText(fieldType);  //参数如：int, varchar, datetime
        Thread.sleep(3000);

        createTaskPage.getElement("confirmButton").click();
        Thread.sleep(3000);

        //修改字段类型
        createTaskPage.getElement("changeNameTypeSelect").click();
        Thread.sleep(3000);
        ElementAction.clickBySpanText("varchar");
        Thread.sleep(3000);
        //修改字段长度
        createTaskPage.getElement("fieldLengthChangeInput").clear();
        Thread.sleep(1000);
        createTaskPage.getElement("fieldLengthChangeInput").sendKeys("30");
        Thread.sleep(2000);

        createTaskPage.getElement("submitButton").click();
        Thread.sleep(3000);
    }

    public void configTask(String taskName, String taskCycle) throws Exception {
        createTaskPage.getElement("taskNameInput").sendKeys(taskName);

        WebElement webElement = createTaskPage.getElement("effectiveDateInput");
        webElement.clear();
        webElement.sendKeys(DateUtil.getDateLiteOnlyDay());
        Thread.sleep(3000);
        createTaskPage.getElement("effectiveDateTitle").click();
        Thread.sleep(3000);

        createTaskPage.getElement("taskCycleSelect").click();
        Thread.sleep(2000);
        ElementAction.clickBySpanText(taskCycle);
        Thread.sleep(1000);

        //createTaskPage.getElement(driver, "executeTimeInput").sendKeys(DateUtil.getAfterDate(60000));
        createTaskPage.getElement("startTimeInput").clear();
        Thread.sleep(2000);
        createTaskPage.getElement("startTimeInput").sendKeys(DateUtil.getAfterDateOnlySecondHalf(60000));
        Thread.sleep(2000);
        createTaskPage.getElement("startTimeInputText").click();
        Thread.sleep(2000);

        createTaskPage.getElement("amountConfigInput").sendKeys("1");
        createTaskPage.getElement("amountConfigInput2").sendKeys("10000000");
        createTaskPage.getElement("amountUnitSelect").click();
        Thread.sleep(2000);
        ElementAction.clickBySpanText("条");
        Thread.sleep(2000);

        createTaskPage.getElement("errorSelect").click();
        Thread.sleep(3000);
        ElementAction.clickBySpanText("5");
        Thread.sleep(3000);

        createTaskPage.getElement("run").click();
        Thread.sleep(3000);



    }
}
