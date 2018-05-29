package com.youe.cd.test.service.datasource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DataSourceService {
    public void createDataSource(WebDriver driver, String dsType, String dsEngine, String dsName) throws Exception {
        driver.findElement(By.xpath("//span[contains(text(),'新增数据源')]")).click();
        //driver.findElement(By.xpath("//span[text()='新建数据源']")).click();  //fail, 因为文本有空格等更多内容

        driver.findElement(By.xpath("//label[contains(text(),'数据源分类')]/../div/div/div/span/span")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[not(contains(@style,'display: none'))]/div/div/ul/li/span[text()='" + dsType + "']")).click();
            /*WebElement dbType = driver.findElement(By.xpath("//span[text()='TABLE']"));
            if(!dbType.isDisplayed()) {
                System.out.println("未显示");
            }*/
        //ElementAction.clickBySpanText(driver, "TABLE");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//label[contains(text(),'数据源类型')]/../div/div/div/input")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[not(contains(@style,'display: none'))]/div/div/ul/li/span[text()='" + dsEngine + "']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//label[contains(text(),'数据源名称')]/../div/div/input")).sendKeys(dsName);
        driver.findElement(By.xpath("//label[contains(text(),'数据源描述')]/../div/div/textarea")).sendKeys(dsName + " desc end");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//label[contains(text(),'JDBC URL')]/../div/div/input")).sendKeys("192.168.30.237/test");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//label[contains(text(),'用户名')]/../div/div/input")).sendKeys("root");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//label[contains(text(),'密码')]/../div/div/input")).sendKeys("123456");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//div[text()='测试连通性']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//a[@class='confirm']")).click();
        Thread.sleep(5000);
    }
}
