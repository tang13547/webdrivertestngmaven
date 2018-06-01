package com.youe.cd.test.service.datasource;

import com.youe.cd.test.pageobject.access.CreateDataSourcePage;
import com.youe.cd.test.util.action.ElementAction;
import org.openqa.selenium.WebDriver;

public class DataSourceService {
    public void createDataSource(WebDriver driver, String DSCategory, String DSType, String dsName) throws Exception {
        CreateDataSourcePage createDataSourcePage = new CreateDataSourcePage();


        createDataSourcePage.getElement(driver, "addDSButton").click();
        //driver.findElement(By.xpath("//span[text()='新建数据源']")).click();  //fail, 因为文本有空格等更多内容

        createDataSourcePage.getElement(driver, "DSCategory").click();
        Thread.sleep(3000);

        ElementAction.clickBySpanTextForDS(driver, DSCategory);  //下拉特殊处理
            /*WebElement dbType = driver.findElement(By.xpath("//span[text()='TABLE']"));
            if(!dbType.isDisplayed()) {
                System.out.println("未显示");
            }*/
        //ElementAction.clickBySpanText(driver, "TABLE");
        Thread.sleep(1000);

        createDataSourcePage.getElement(driver, "DSType").click();
        Thread.sleep(3000);

        ElementAction.clickBySpanTextForDS(driver, DSType);  //下拉特殊处理
        Thread.sleep(1000);

        createDataSourcePage.getElement(driver, "DSName").sendKeys(dsName);

        createDataSourcePage.getElement(driver, "DSDescription").sendKeys(dsName + " desc end");
        Thread.sleep(1000);

        createDataSourcePage.getElement(driver, "JDBCUrl").sendKeys("192.168.30.237/test");
        Thread.sleep(1000);

        createDataSourcePage.getElement(driver, "JDBCUserName").sendKeys("root");
        Thread.sleep(1000);

        createDataSourcePage.getElement(driver, "JDBCPassword").sendKeys("123456");
        Thread.sleep(1000);

        createDataSourcePage.getElement(driver, "testConnection").click();
        Thread.sleep(3000);

        createDataSourcePage.getElement(driver, "confirmButton").click();
        Thread.sleep(5000);
    }
}
