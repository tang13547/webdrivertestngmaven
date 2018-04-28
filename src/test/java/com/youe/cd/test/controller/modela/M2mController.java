package com.youe.cd.test.controller.modela;

import com.youe.cd.test.dao.TxtDao;
import com.youe.cd.test.service.modela.ParamSearchWebService;
import com.youe.cd.test.service.modela.SearchWebService;
import com.youe.cd.test.util.Config;
import com.youe.cd.test.util.DateUtil;
import com.youe.cd.test.util.action.ElementAction;
import com.youe.cd.test.util.testbase.TestBase;
import com.youe.cd.test.util.verify.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class M2mController extends TestBase {
    String nowTimeStr = DateUtil.getDateLite();
    String dataSourceName = "uitest源forMysql_" + nowTimeStr;

    @Test(priority = 1, enabled = true, description = "创建表数据源")
    public void runTestCreateDataSource() {
        try {
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='115']")).click();
            Thread.sleep(3000);
            driver.findElement(By.linkText("数据接入")).click();
            driver.findElement(By.linkText("接入管理")).click();

            driver.findElement(By.xpath("//span[contains(text(),'新建数据源')]")).click();
            //driver.findElement(By.xpath("//span[text()='新建数据源']")).click();  //fail, 因为文本有空格等更多内容

            driver.findElement(By.xpath("//label[contains(text(),'数据源类型')]/../div/div/div/span/span")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//div[not(contains(@style,'display: none'))]/div/div/ul/li/span[text()='TABLE']")).click();
            /*WebElement dbType = driver.findElement(By.xpath("//span[text()='TABLE']"));
            if(!dbType.isDisplayed()) {
                System.out.println("未显示");
            }*/
            //ElementAction.clickBySpanText(driver, "TABLE");
            Thread.sleep(1000);
            driver.findElement(By.xpath("//label[contains(text(),'数据源引擎')]/../div/div/div/input")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//span[text()='MYSQL']")).click();
            Thread.sleep(1000);

            driver.findElement(By.xpath("//label[contains(text(),'数据源名称')]/../div/div/input")).sendKeys(dataSourceName);
            driver.findElement(By.xpath("//label[contains(text(),'数据源描述')]/../div/div/textarea")).sendKeys("uitest源forMysql desc");
            Thread.sleep(1000);
            driver.findElement(By.xpath("//label[contains(text(),'JDBC url')]/../div/div/input")).sendKeys("192.168.30.237/test");
            Thread.sleep(1000);
            driver.findElement(By.xpath("//label[contains(text(),'用户名')]/../div/div/input")).sendKeys("root");
            Thread.sleep(1000);
            driver.findElement(By.xpath("//label[contains(text(),'密码')]/../div/div/input")).sendKeys("123456");
            Thread.sleep(1000);

            driver.findElement(By.xpath("//div[text()='连通性测试']")).click();
            Thread.sleep(3000);

            driver.findElement(By.xpath("//a[@class='confirm']")).click();
            Thread.sleep(5000);

            boolean actualElement= ElementAction.isElementPresent(driver,By.xpath("//div[text()='" + dataSourceName + "']"));

            Assert.assertTrue(actualElement);

        } catch (Exception e) {
            //e.printStackTrace();
            logger.error("[logger] 异常信息为：", e);
        }

    }

    @Test(priority = 1, enabled = true, description = "表到表流程")
    public void runTestM2mflow() {
        String nowTimeEssential = DateUtil.getDateLiteEssential();
        String dataSetName = "UITest集_" + nowTimeEssential;
        String taskName = "uitaskm2m_" + nowTimeEssential;

        try {
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='115']")).click();
            Thread.sleep(3000);
            driver.findElement(By.linkText("数据接入")).click();
            driver.findElement(By.linkText("接入管理")).click();

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

            String actualNum = driver.findElement(By.xpath("//header[contains(text(),'行数：')]/span")).getText();
            Assert.assertEquals(actualNum, "3");

        } catch (Exception e) {
            //e.printStackTrace();
            logger.error("[logger] 异常信息为：", e);
        }

    }

    @Test(priority = 2, enabled = false, description = "无登陆通过Txt搜索")
    public void runtestSearchWebByTxtWithoutLogin() {
        try {
            String searchKey = TxtDao.getTxtList(Config.txtFilePath).get(0);
            ParamSearchWebService.paramSearchWeb(driver, searchKey);
            logger.info("[logger] testcase2 testing...");
            Assert.assertEquals(driver.getTitle(), "ppaa_百度搜索ch");
            //Verify.verifyError();  //第二步：在代码最后，通过errorBuffer抛出断言失败AssertionError异常(错误)

        } catch (Exception e) {
            //e.printStackTrace();
            logger.error("[logger] 异常信息为：", e);
        }
    }

    @Test(priority = 3, enabled = false)
    public void tempTestMethod() {
        try {

        } catch (Exception e) {
            //e.printStackTrace();
            logger.error("[logger] 异常信息为：", e);
        }
    }

}
