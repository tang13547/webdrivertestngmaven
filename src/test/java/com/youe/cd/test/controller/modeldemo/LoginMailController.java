package com.youe.cd.test.controller.modeldemo;

import com.youe.cd.test.controller.TestBase;
import com.youe.cd.test.pageobject.loginmail.LoginMailPage;
import com.youe.cd.test.service.loginmail.LoginMailService;
import com.youe.cd.test.util.action.WebTest;
import com.youe.cd.test.util.config.Config;
import com.youe.cd.test.util.listener.ScreenShotOnFailureListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class LoginMailController extends TestBase {
    public Logger logger = LoggerFactory.getLogger(this.getClass());

    @Parameters({"testEnv","testBrowser"})  //设置测试方法的入参，且设置了几个，下面的测试方法就必须要定义几个
    @BeforeClass
    public void setUpTest(String testEnv, String testBrowser) {  //即使是前面传递了的参数，在此方法中也要定义类型,也不能直接使用传参，否则不能resolve
        try {
            WebTest.setUp(testEnv, testBrowser); //实现了将其它类中的方法传递给主类中的属性
            logger.info("[logger] 类：" + this.getClass().getName() + " 测试初使化driver完成...");
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
    public void testAfterMethod() {}

    @AfterClass
    public void tearDownTest() {
        try {
            WebTest.logoutMail();
            WebTest.tearDown();
        } catch (Exception e) {
            logger.error("[logger] 异常信息为：", e);
        }
    }

    @Test(description="126邮箱登录用例")
    public void loginMailTest() {
        LoginMailService loginMailService = new LoginMailService();

        try {
            //打开126邮箱登录页面
            driver.get(Config.baseUrl);
            Thread.sleep(3000);

            //调用服务层方法实现登录
            loginMailService.loginMail();

            //获取实际值
            LoginMailPage loginMailsPage = new LoginMailPage();
            String actualText = loginMailsPage.getElement("welcomeUserInfo").getText();

            //断言
            Assert.assertEquals(actualText, "tang13547@126.com");
        } catch (Exception e) {
            WebTest.handleException(e);
        }
    }
}
