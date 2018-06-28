package com.youe.cd.test.controller.modela;

import com.youe.cd.test.controller.TestBase;
import com.youe.cd.test.service.access.AccessService;
import com.youe.cd.test.service.datasource.DataSourceService;
import com.youe.cd.test.util.DateUtil;
import com.youe.cd.test.util.FtpUtil;
import com.youe.cd.test.util.config.Config;
import com.youe.cd.test.util.config.RunTimeConfig;
import com.youe.cd.test.util.action.ElementAction;
import com.youe.cd.test.util.action.WebTest;
import com.youe.cd.test.util.action.WebTestDaaS;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ftp2mController extends TestBase {
    //String nowTimeStr = DateUtil.getDateLiteEssential();
    //String dataSourceName = "源F" + nowTimeStr;

    DataSourceService dataSourceService = new DataSourceService();
    AccessService accessService = new AccessService();

    @Test(priority = 1, enabled = true, description = "创建ftp数据源")
    public void runTestCreateDataSourceForFtp() {
        try {
            WebTestDaaS.goToDataSourceManagementPage();

            dataSourceService.createDataSource(driver, "半结构化存储", "FTP", RunTimeConfig.dataSourceNameFtp, Config.FTPConnMap);

            boolean actualElement= ElementAction.isElementPresent(By.xpath("//div[contains(text(),'" + RunTimeConfig.dataSourceNameFtp + "')]"));

            Assert.assertTrue(actualElement);

        } catch (Exception e) {
            WebTest.handleException(e);
        }

    }

    @Test(priority = 2, enabled = true, description = "ftp到表流程")
    public void runTestFtp2mflow() {
        //String nowTimeEssential = DateUtil.getDateLiteEssential();
        //String dataSetName = "UI集_" + nowTimeEssential;
        //String taskName = "uitaskm2m_" + nowTimeEssential;
        String tabName = "tab" + RunTimeConfig.nowTimeEssential;

        try {
            //准备上传FTP测试文件
            FtpUtil ftp = new FtpUtil();
            ftp.deleteFile("test2/subftp", "testfile3112n.txt");
            ftp.uploadFile( "./src/test/resources/data/accessdata/testfile3112n.txt","test2/subftp", "testfile3112n.txt");
            logger.info("上传FTP初始测试文件完成");

            WebTestDaaS.goToTaskManagementPage();

            accessService.createTaskFlow("FTP", RunTimeConfig.dataSourceNameFtp, "test2/subftp","txt",",","MYSQL", RunTimeConfig.dataSetNameF2M, tabName, "12", "int");
            accessService.configTask(RunTimeConfig.taskNameF2M, "日");

            WebTestDaaS.goToMetaManagementEditPageViewData(RunTimeConfig.dataSetNameF2M);

            //String actualNum = driver.findElement(By.xpath("//header[contains(text(),'行数：')]/span")).getText();
            String actualNum = driver.findElement(By.xpath("//header[contains(text(),'行数：')]/span")).getText();
            Assert.assertEquals(actualNum, "5");

        } catch (Exception e) {
            //e.printStackTrace();
            //logger.error("[logger] 异常信息为：", e);
            WebTest.handleException(e);
        }

    }
}
