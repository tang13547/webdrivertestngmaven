package com.youe.cd.test.controller;

import com.youe.cd.test.util.Config;
import com.youe.cd.test.util.action.WebTest;
import com.youe.cd.test.util.action.WebTestDaaS;
import com.youe.cd.test.util.listener.ScreenShotOnFailureListener;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class TestBase {
    public static WebDriver driver;
    //Logger logger = Logger.getLogger(ModelAController.class);
    public Logger logger = LoggerFactory.getLogger(this.getClass().getSuperclass()); //因为TestBase是父类，如果获取getSuperClass()的结果就是testBase类

    @Parameters({"testEnv","testBrowser"})  //设置测试方法的入参，且设置了几个，下面的测试方法就必须要定义几个
    @BeforeClass
    public void setUpTest(String testEnv, String testBrowser) {  //即使是前面传递了的参数，在此方法中也要定义类型,也不能直接使用传参，否则不能resolve
        try {
            WebTest.setUp(testEnv, testBrowser); //实现了将其它类中的方法传递给主类中的属性
            logger.info("[logger] 类：" + this.getClass().getName() + " 测试初使化driver完成...");
            //增加一个登陆的调用
            WebTest.loginByExcel(Config.baseUrl, Config.excelFilePath);
            //WebTest.loginWithVerifyCode(driver, Config.baseUrl2);
            //WebTest.loginWithVerifyCodeByCsv(driver, Config.baseUrl2, Config.csvFilePath);
            //WebTest.loginWithVerifyCodeByExcel(driver, Config.baseUrl2, Config.excelFilePath);
        } catch (Exception e) {
            //e.printStackTrace();
            logger.error("[logger] 异常信息为：", e);
        }
    }

    @BeforeMethod
    //测试失败时自动截图：获取driver，类名及每个用例的方法名，并赋给测试失败时自动截图的listener
    public void testBeforeMethod(Method method) {
        ScreenShotOnFailureListener.driver = this.driver;  //将测试类中的driver赋值给测试失败时自动截图的listener
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
            //增加一个登出的调用
            WebTest.logout();
            //WebTest.logoutBaiduInSearchPage(driver);
            WebTest.tearDown();
        } catch (Exception e) {
            //e.printStackTrace();
            logger.error("[logger] 异常信息为：", e);
        }

        logger.info("[logger] 类：" + this.getClass().getName() + " 测试结束");
    }

}
