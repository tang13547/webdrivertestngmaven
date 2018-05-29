package com.youe.cd.test.controller.modela;

import com.youe.cd.test.dao.TxtDao;
import com.youe.cd.test.service.access.AccessService;
import com.youe.cd.test.service.datasource.DataSourceService;
import com.youe.cd.test.service.modela.ParamSearchWebService;
import com.youe.cd.test.service.modela.SearchWebService;
import com.youe.cd.test.util.Config;
import com.youe.cd.test.util.DateUtil;
import com.youe.cd.test.util.action.ElementAction;
import com.youe.cd.test.util.action.WebTest;
import com.youe.cd.test.util.testbase.TestBase;
import com.youe.cd.test.util.verify.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class M2mController extends TestBase {
    String nowTimeStr = DateUtil.getDateLiteEssential();
    String dataSourceName = "ut源Mysql_" + nowTimeStr;

    DataSourceService dataSourceService = new DataSourceService();
    AccessService accessService = new AccessService();

    @Test(priority = 1, enabled = true, description = "创建表数据源")
    public void runTestCreateDataSource() {
        try {
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='115']")).click();
            Thread.sleep(3000);

            driver.findElement(By.linkText("数据接入")).click();
            //driver.findElement(By.linkText("接入管理")).click();
            driver.findElement(By.xpath("//*[contains(text(),'数据源管理')]")).click();

            dataSourceService.createDataSource(driver, "关系型数据库", "MYSQL", dataSourceName);

            boolean actualElement= ElementAction.isElementPresent(driver,By.xpath("//div[text()='" + dataSourceName + "']"));

            Assert.assertTrue(actualElement);

        } catch (Exception e) {
            //e.printStackTrace();
            //logger.error("[logger] 异常信息为：", e);
            WebTest.handleException(e);
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
            //driver.findElement(By.linkText("接入管理")).click();
            driver.findElement(By.xpath("//*[contains(text(),'数据源管理')]")).click();

            accessService.createTaskFlow(driver, dataSourceName, dataSetName, taskName, nowTimeEssential);

            String actualNum = driver.findElement(By.xpath("//header[contains(text(),'行数：')]/span")).getText();
            Assert.assertEquals(actualNum, "3");

        } catch (Exception e) {
            //e.printStackTrace();
            //logger.error("[logger] 异常信息为：", e);
            WebTest.handleException(e);
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
