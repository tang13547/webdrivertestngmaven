package com.youe.cd.test.service.datasource;

import com.youe.cd.test.pageobject.access.CreateDataSourcePage;
import com.youe.cd.test.util.action.ElementAction;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class DataSourceService {
    CreateDataSourcePage createDataSourcePage = new CreateDataSourcePage();

    public void createDataSource(WebDriver driver, String DSCategory, String DSType, String dsName, Map<String,String> ConnMap) throws Exception {
        //CreateDataSourcePage createDataSourcePage = new CreateDataSourcePage();


        createDataSourcePage.getElement("addDSButton").click();
        //driver.findElement(By.xpath("//span[text()='新建数据源']")).click();  //fail, 因为文本有空格等更多内容

        createDataSourcePage.getElement("DSCategory").click();
        Thread.sleep(3000);

        ElementAction.clickBySpanText(DSCategory);  //下拉特殊处理
            /*WebElement dbType = driver.findElement(By.xpath("//span[text()='TABLE']"));
            if(!dbType.isDisplayed()) {
                System.out.println("未显示");
            }*/
        //ElementAction.clickBySpanText(driver, "TABLE");
        Thread.sleep(1000);

        createDataSourcePage.getElement("DSType").click();
        Thread.sleep(3000);

        ElementAction.clickBySpanText(DSType);  //下拉特殊处理
        Thread.sleep(1000);

        createDataSourcePage.getElement("DSName").sendKeys(dsName);

        createDataSourcePage.getElement("DSDescription").sendKeys(dsName + " desc end");
        Thread.sleep(1000);

        if(DSCategory.equals("关系型数据库")) {
            createDataSourcePage.getElement("JDBCUrl").sendKeys(ConnMap.get("MYSQL_JDBCURL").toString());
            Thread.sleep(1000);
            createDataSourcePage.getElement("JDBCUserName").sendKeys(ConnMap.get("MYSQL_USERNAME").toString());
            Thread.sleep(1000);
            createDataSourcePage.getElement("JDBCPassword").sendKeys(ConnMap.get("MYSQL_PASSWORD").toString());
            Thread.sleep(1000);
        } else if(DSCategory.equals("半结构化存储")) {
            createDataSourcePage.getElement("UrlAddress").sendKeys(ConnMap.get("FTP_URL").toString());
            Thread.sleep(1000);
            createDataSourcePage.getElement("port").sendKeys(ConnMap.get("FTP_PORT").toString());
            Thread.sleep(1000);
            createDataSourcePage.getElement("JDBCUserName").sendKeys(ConnMap.get("FTP_USERNAME").toString());
            Thread.sleep(2000);
            createDataSourcePage.getElement("JDBCPassword").sendKeys(ConnMap.get("FTP_PASSWORD").toString());
            Thread.sleep(2000);
        }

        createDataSourcePage.getElement("testConnection").click();
        Thread.sleep(3000);

        createDataSourcePage.getElement("confirmButton").click();
        Thread.sleep(5000);
    }


}
