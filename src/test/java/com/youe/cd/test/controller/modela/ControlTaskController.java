package com.youe.cd.test.controller.modela;

import com.youe.cd.test.controller.TestBase;
import com.youe.cd.test.dao.PoiExcelDao;
import com.youe.cd.test.dao.TxtDao;
import com.youe.cd.test.service.keypersoncontrol.ControlManagementService;
import com.youe.cd.test.service.modela.ParamSearchWebService;
import com.youe.cd.test.service.modela.SearchWebService;
import com.youe.cd.test.util.action.ElementAction;
import com.youe.cd.test.util.action.WebTest;
import com.youe.cd.test.util.action.WebTestFuShan;
import com.youe.cd.test.util.config.Config;
import com.youe.cd.test.util.listener.ScreenShotOnFailureListener;
import com.youe.cd.test.util.verify.Verify;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class ControlTaskController extends TestBase {
    public Logger logger = LoggerFactory.getLogger(this.getClass());
    ControlManagementService controlManagementService = new ControlManagementService();

    @Parameters({"testEnv","testBrowser"})  //设置测试方法的入参，且设置了几个，下面的测试方法就必须要定义几个
    @BeforeClass
    public void setUpTest(String testEnv, String testBrowser) {  //即使是前面传递了的参数，在此方法中也要定义类型,也不能直接使用传参，否则不能resolve
        try {
            WebTest.setUp(testEnv, testBrowser); //实现了将其它类中的方法传递给主类中的属性
            logger.info("[logger] 类：" + this.getClass().getName() + " 测试初使化driver完成...");
            //增加一个登陆的调用
            WebTest.loginByExcel(Config.baseUrl, Config.excelFilePath);

        } catch (Exception e) {
            //e.printStackTrace();
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
        //6WebTestDaaS.goToHomePage();
    }

    @AfterClass
    public void tearDownTest() {
        try {
            //6WebTest.logout();
            //WebTest.tearDown();
        } catch (Exception e) {
            logger.error("[logger] 异常信息为：", e);
        }

        logger.info("[logger] 类：" + this.getClass().getName() + " 测试结束");
    }


    @Test(priority = 1)
    public void preStepMacTest() {
        try {
            WebTestFuShan.goToStabilityControlTaskPage();

            controlManagementService.preStepMac();

        } catch (Exception e) {
            WebTest.handleException(e);
        }

    }

    //参数化输入mac测试
    @Test(priority = 2, dataProvider = "macProvider", dataProviderClass = PoiExcelDao.class)
    public void tempTestMethod(String mac) {
        try {
            System.out.println("开始ing...");
            //WebTest.loginByExcel(Config.baseUrl, username, password);
            controlManagementService.addMac(mac);

            //Assert.assertTrue(ElementAction.isContainsPageText("日均数据接入ch"));

        } catch (Exception e) {
            WebTest.handleException(e);
        }
    }

    @Test(priority = 3)
    public void afterStepMacTest() {
        try {
            //controlManagementService.afterStepMac();

        } catch (Exception e) {
            WebTest.handleException(e);
        }
    }

}
