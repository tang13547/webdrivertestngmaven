package com.youe.cd.test.controller.modela; //申明本类文件所处的包位置

//import org.apache.log4j.Logger;
import com.youe.cd.test.controller.TestBase;

//import org.junit.*;
import com.youe.cd.test.dao.PoiExcelDao;
import com.youe.cd.test.pageobject.login.LoginPage;
import com.youe.cd.test.util.action.ElementAction;
import com.youe.cd.test.util.action.WebTest;
import com.youe.cd.test.util.action.WebTestDaaS;
import com.youe.cd.test.util.config.Config;
import com.youe.cd.test.util.listener.ScreenShotOnFailureListener;
import com.youe.cd.test.util.verify.Verify;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.*;
import org.testng.annotations.*;

import com.youe.cd.test.dao.TxtDao;
import com.youe.cd.test.service.modela.*;

import java.lang.reflect.Method;

//import static com.youe.cd.test.controller.TestBase.driver; //不使用引入driver的方法，而使用继承子类重写overrides父类方法实现：使用不同的注释

public class ModelAController extends TestBase {
	public Logger logger = LoggerFactory.getLogger(this.getClass());

	@Parameters({"testEnv","testBrowser"})  //设置测试方法的入参，且设置了几个，下面的测试方法就必须要定义几个
	@BeforeClass
	public void setUpTest(String testEnv, String testBrowser) {  //即使是前面传递了的参数，在此方法中也要定义类型,也不能直接使用传参，否则不能resolve
		try {
			WebTest.setUp(testEnv, testBrowser); //实现了将其它类中的方法传递给主类中的属性
			logger.info("[logger] 类：" + this.getClass().getName() + " 测试初使化driver完成...");
			//增加一个登陆的调用
			//6WebTest.loginByExcel(Config.baseUrl, Config.excelFilePath);
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
		System.out.println("aftermedhod 1");
	}

	@AfterClass
	public void tearDownTest() {
		try {
			//6WebTest.logout();
			WebTest.tearDown();
		} catch (Exception e) {
			logger.error("[logger] 异常信息为：", e);
		}

		logger.info("[logger] 类：" + this.getClass().getName() + " 测试结束");
	}



	@Test(priority = 1, enabled = false, description = "无登陆搜索")
	public void runtestSearchWebWithoutLogin() {
		try {
			driver.get(Config.baseUrl);
			Thread.sleep(5000);
			String homeHandle = driver.getWindowHandle();
			
			SearchWebService.searchWeb();
			//Assert.assertEquals(driver.getTitle(), "聚力视频_百度百科ch");
			Verify.verifyEquals(driver.getTitle(), "聚力视频_百度百科ch");  //断言之后如还要代码要执行，第一步：由Assert->Verify
			logger.info("[logger] 验证title结束");

			driver.close();
			driver.switchTo().window(homeHandle);

			Verify.verifyError();  //第二步：在代码最后，通过errorBuffer抛出断言失败AssertionError异常(错误)
		} catch (Exception e) {
			//e.printStackTrace();
			logger.error("[logger] 异常信息为：", e);
		}
				
	}
		
	@Test(priority = 2, enabled = false, description = "无登陆通过Txt搜索")
	public void runtestSearchWebByTxtWithoutLogin() {
		try {
			String searchKey = TxtDao.getTxtList(Config.txtFilePath).get(0);
			ParamSearchWebService.paramSearchWeb(searchKey);
			logger.info("[logger] testcase2 testing...");
			Assert.assertEquals(driver.getTitle(), "ppaa_百度搜索ch");
			//Verify.verifyError();  //第二步：在代码最后，通过errorBuffer抛出断言失败AssertionError异常(错误)

		} catch (Exception e) {
			//e.printStackTrace();
			logger.error("[logger] 异常信息为：", e);
		}
	}

	//参数化登录测试
	@Test(dataProvider = "loginProvider", dataProviderClass = PoiExcelDao.class)
	public void tempTestMethod(String username, String password) {
		try {
			System.out.println("开始ing...");
			WebTest.loginByExcel(Config.baseUrl, username, password);

			Assert.assertTrue(ElementAction.isContainsPageText("日均数据接入"));
			
		} catch (Exception e) {
			//e.printStackTrace();
			logger.error("[logger] 异常信息为：", e);
		}
	}

}
