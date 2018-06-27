package com.youe.cd.test.controller.modela;

import com.youe.cd.test.dao.TxtDao;
import com.youe.cd.test.service.access.AccessService;
import com.youe.cd.test.service.datasource.DataSourceService;
import com.youe.cd.test.service.modela.ParamSearchWebService;
import com.youe.cd.test.util.Config;
import com.youe.cd.test.util.DateUtil;
import com.youe.cd.test.util.RunTimeConfig;
import com.youe.cd.test.util.action.ElementAction;
import com.youe.cd.test.util.action.WebTest;
import com.youe.cd.test.util.action.WebTestDaaS;
import com.youe.cd.test.controller.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class M2mController extends TestBase {
    String nowTimeStr = DateUtil.getDateLiteEssential();
    String dataSourceName = "源M" + nowTimeStr;

    DataSourceService dataSourceService = new DataSourceService();
    AccessService accessService = new AccessService();

    @Test(priority = 0, enabled = true, description = "创建表数据源")
    public void runTestCreateDataSource() {
        try {
            WebTestDaaS.goToDataSourceManagementPage();

            dataSourceService.createDataSource(driver, "关系型数据库", "MYSQL", dataSourceName, RunTimeConfig.MysqlConnMap);

            boolean actualElement= ElementAction.isElementPresent(By.xpath("//div[text()='" + dataSourceName + "']"));

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
        String dataSetName = "UI集_" + nowTimeEssential;
        String taskName = "uitaskm2m_" + nowTimeEssential;
        String tabRulePrefix = "tab" + nowTimeEssential;

        try {
            WebTestDaaS.goToTaskManagementPage();

            accessService.createTaskFlow(dataSourceName, dataSetName,tabRulePrefix);
            accessService.configTask(taskName, "天");

            WebTestDaaS.goToMetaManagementEditPageViewData(dataSetName);

            String actualNum = driver.findElement(By.xpath("//header[contains(text(),'行数：')]/span")).getText();
            Assert.assertEquals(actualNum, "3");

        } catch (Exception e) {
            //e.printStackTrace();
            //logger.error("[logger] 异常信息为：", e);
            WebTest.handleException(e);
        }

    }



}
