package com.youe.cd.test.controller.modela; //申明本类文件所处的包位置

//import org.apache.log4j.Logger;
import com.youe.cd.test.util.*;
import com.youe.cd.test.util.testbase.TestBase;

//import org.junit.*;
import com.youe.cd.test.util.verify.Verify;
import org.testng.*;
import org.testng.annotations.*;

import com.youe.cd.test.dao.TxtDao;
import com.youe.cd.test.service.modela.*;

public class ModelAController extends TestBase {
	@Test(priority = 1, enabled = true, description = "无登陆搜索")
	public void runtestSearchWebWithoutLogin() {
		try {
			driver.get(Config.baseUrl);
			Thread.sleep(5000);
			String homeHandle = driver.getWindowHandle();
			
			SearchWebService.searchWeb(driver);			
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
		
	@Test(priority = 2, enabled = true, description = "无登陆通过Txt搜索")
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
