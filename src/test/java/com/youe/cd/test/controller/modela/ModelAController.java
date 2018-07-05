package com.youe.cd.test.controller.modela; //申明本类文件所处的包位置

//import org.apache.log4j.Logger;
import com.youe.cd.test.controller.TestBase;

//import org.junit.*;
import com.youe.cd.test.dao.PoiExcelDao;
import com.youe.cd.test.pageobject.login.LoginPage;
import com.youe.cd.test.util.action.ElementAction;
import com.youe.cd.test.util.config.Config;
import com.youe.cd.test.util.verify.Verify;
import org.testng.*;
import org.testng.annotations.*;

import com.youe.cd.test.dao.TxtDao;
import com.youe.cd.test.service.modela.*;

public class ModelAController extends TestBase {
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
	
	@Test(dataProvider = "loginProvider", dataProviderClass = PoiExcelDao.class)
	public void tempTestMethod(String username, String password) {
		try {
			System.out.println("开始ing...");
			driver.get(Config.baseUrl);  //打开网页首页
			Thread.sleep(5000);

			LoginPage loginPage = new LoginPage();

			loginPage.getElement("userName").clear();
			loginPage.getElement("userName").sendKeys(username);

			loginPage.getElement("password").clear();
			loginPage.getElement("password").sendKeys(password);
			Thread.sleep(5000);

			loginPage.getElement("submit").click();
			Thread.sleep(5000);

			Assert.assertTrue(ElementAction.isContainsPageText("日均数据接入"));
			
		} catch (Exception e) {
			//e.printStackTrace();
			logger.error("[logger] 异常信息为：", e);
		}
	}

}
