package com.youe.cd.test.service.access;

import com.youe.cd.test.util.DateUtil;
import com.youe.cd.test.util.action.ElementAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccessService {
    public static void createTaskFlow(WebDriver driver, String dataSourceName, String dataSetName, String taskName, String nowTimeEssential) throws Exception {
        driver.findElement(By.xpath("//span[contains(text(),'新建任务')]")).click();
        //driver.findElement(By.xpath("/html/body/section/section/section/main/div[2]/div/div[2]/form/div[1]/div/div/div[1]/input")).click();
        //driver.findElement(By.xpath("//label[text()='数据源类型']/../div/div/div/span/span/i")).click();
        driver.findElement(By.xpath("//input[@placeholder='请选择数据源类型']")).click();
        Thread.sleep(2000);
        //driver.findElement(By.xpath("//span[text()='MYSQL']")).click();
        ElementAction.clickBySpanText(driver, "MYSQL");
        Thread.sleep(2000);
        //driver.findElement(By.xpath("/html/body/section/section/section/main/div[2]/div/div[2]/form/div[2]/div/div/div[1]/input")).click();
        driver.findElement(By.xpath("//label[text()='数据源名称']/../div/div/div/span/span")).click();
        Thread.sleep(2000);
        //driver.findElement(By.xpath("//span[text()='test源forMysql-joe']")).click();
        ElementAction.clickBySpanText(driver, dataSourceName);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@class='confirm']")).click();
        Thread.sleep(5000);

        driver.findElement(By.xpath("//div[text()='testtable']/../../td[1]")).click();
        //driver.findElement(By.xpath("//div[contains(text(),'baidu_tieba_20000item')]")).findElement(By.xpath("./../../td[1]/div/label/span")).click();
        Thread.sleep(5000);

        driver.findElement(By.xpath("//input[@placeholder='请选择业务组']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='成都优易']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@placeholder='请输入内容']")).sendKeys(dataSetName);
        Thread.sleep(3000);

        driver.findElement(By.xpath("//div[contains(text(),'下一步')]")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//form/div/div/div[2]/input")).sendKeys("tab_" + nowTimeEssential);
        driver.findElement(By.xpath("//a[@class='confirm']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//div[@class='submit' and text()='保存']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='submit' and contains(text(),'提交')]")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//label[contains(text(),'任务名称')]/../div/div/input")).sendKeys(taskName);
        driver.findElement(By.xpath("//label[text()='采集周期']/../div/div/div/input")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='小时']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//label[text()='执行时间']/../div/div/input")).sendKeys(DateUtil.getAfterDate(60000));
        driver.findElement(By.xpath("//label[text()='写入量配置']/../div/div/div[1]/input")).sendKeys("1");
        driver.findElement(By.xpath("//label[text()='写入量配置']/../div/div/div[2]/input")).sendKeys("10000000");
        driver.findElement(By.xpath("//label[text()='写入量配置']/../div/div/div[3]/div/span/span/i")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='条']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//label[text()='报错']/../div/div/div/div/span/span")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[text()='5']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[text()='运行']")).click();
        Thread.sleep(3000);

        Thread.sleep(90000);
        driver.findElement(By.xpath("//a[contains(text(),'元数据管理')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[text()='数据集列表']")).click();
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
