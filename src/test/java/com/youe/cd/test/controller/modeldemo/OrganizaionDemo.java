package com.youe.cd.test.controller.modeldemo;

import com.youe.cd.test.controller.TestBase;
import com.youe.cd.test.dao.PoiExcelDao;
import com.youe.cd.test.dao.TxtDao;
import com.youe.cd.test.service.modela.ParamSearchWebService;
import com.youe.cd.test.service.modela.SearchWebService;
import com.youe.cd.test.util.action.ElementAction;
import com.youe.cd.test.util.action.WebTest;
import com.youe.cd.test.util.action.WebTestDaaS;
import com.youe.cd.test.util.config.Config;
import com.youe.cd.test.util.listener.ScreenShotOnFailureListener;
import com.youe.cd.test.util.verify.Verify;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class OrganizaionDemo extends TestBase {
    public Logger logger = LoggerFactory.getLogger(this.getClass());

    @Parameters({"testEnv","testBrowser"})  //设置测试方法的入参，且设置了几个，下面的测试方法就必须要定义几个
    @BeforeClass
    public void setUpTest(String testEnv, String testBrowser) {
        try {
            WebTest.setUp(testEnv, testBrowser);
            WebTest.loginByExcel(Config.baseUrl, Config.excelFilePath);
        } catch (Exception e) {
            logger.error("[logger] 异常信息为：", e);
        }
    }

    @BeforeMethod
    //测试失败时自动截图：获取driver，类名及每个用例的方法名，并赋给测试失败时自动截图的listener
    public void testBeforeMethod(Method method) {
        ScreenShotOnFailureListener.driver = driver;  //将测试类中的driver赋值给测试失败时自动截图的listener
        ScreenShotOnFailureListener.className = this.getClass().getSimpleName();
        ScreenShotOnFailureListener.methodName = method.getName();
    }

    @AfterMethod
    public void testAfterMethod() {
        WebTestDaaS.goToHomePage();
    }

    @AfterClass
    public void tearDownTest() {
        try {
            WebTest.logout();
            WebTest.tearDown();
        } catch (Exception e) {
            logger.error("[logger] 异常信息为：", e);
        }
    }

    //参数化登录测试
    @Test(dataProvider = "loginProvider", dataProviderClass = PoiExcelDao.class)
    public void tempTestMethod(String username, String password) {
        try {
            WebTest.loginByExcel(Config.baseUrl, username, password);
            Assert.assertTrue(ElementAction.isContainsPageText("日均数据接入"));
        } catch (Exception e) {
            WebTest.handleException(e);
        }
    }

}
