package com.youe.cd.test.util.action;

import java.util.concurrent.TimeUnit;

//7 import org.junit.*;
//7 import static org.junit.Assert.*;
import com.youe.cd.test.dao.PoiExcelDao;
import com.youe.cd.test.util.Config;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.testng.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions; //ChromeOptions类处理Chrome窗口上的yellow alarm
import org.openqa.selenium.firefox.FirefoxDriver;

import com.youe.cd.test.dao.CsvDao;
import com.youe.cd.test.dao.EasyOcrDao;
import com.youe.cd.test.dao.ExcelDao;
import com.youe.cd.test.pageobject.login.LoginPage;

//import jxl.Sheet;
import org.apache.poi.ss.usermodel.*;

import java.util.ArrayList;

//import java.util.HashSet;
import org.openqa.selenium.interactions.Actions; //使用Actions类处理moveToElement()
import org.testng.Assert;


public class WebTest {
  //private boolean acceptNextAlert = true;
  private static StringBuffer verificationErrors = new StringBuffer();
  static Logger logger = LoggerFactory.getLogger(WebTest.class);

  //@BeforeTest
  //@Parameters({"testEnv","testBrowser"}) //只需在最上层加入，此处不要
  public static WebDriver setUp(WebDriver driver, String testEnv, String testBrowser) throws Exception {  //必须返回 Webdriver,否则无法传递给主类中的属性
	if(testBrowser.equals("firefox")) {
		//ProfilesIni allProfiles =new ProfilesIni();
		//FirefoxProfile profile = allProfiles.getProfile("SeleniumProfile"); //修改值为: SeleniumProfile
		System.setProperty("webdriver.gecko.driver", Config.firefoxdriverPath);
		driver = new FirefoxDriver(); //处理取消每日提醒加入了profile类对象
		driver.manage().window().maximize(); //最大化窗口
	} else if (testBrowser.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", Config.chromedriverPath);
		ChromeOptions options = new ChromeOptions();
		options.addArguments(new String[] {"-test-type"}); //去掉Chrome上的yellow alarm
		options.addArguments(new String[] {"-start-maximized"}); //最大化窗口	
		//options.setExperimentalOption("excludeSwitches","ignore-certificate-errors"); //此方法未验证通过
		driver = new ChromeDriver(options);
	} else if (testBrowser.equals("ie")) {
		System.setProperty("webdriver.ie.driver", Config.iedriverPath);
		DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
		dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		dc.setCapability("ignoreProtectedModeSettings", true);
		driver = new InternetExplorerDriver(dc);
	} else {
		logger.warn("设置testBrowser错误（要求为chrome/firefox/ie中的一个），系统将以默认testBrowser = chrome执行");
		System.setProperty("webdriver.chrome.driver", Config.chromedriverPath);
		ChromeOptions options = new ChromeOptions();
		options.addArguments(new String[] {"-test-type"}); //去掉Chrome上的yellow alarm
		options.addArguments(new String[] {"-start-maximized"}); //最大化窗口
		//options.setExperimentalOption("excludeSwitches","ignore-certificate-errors"); //此方法未验证通过
		driver = new ChromeDriver(options);
	}
	
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    return driver;
  }

  //@Test
  /*5public static void login(WebDriver driver,String baseUrl) throws Exception {
    driver.get(baseUrl);  //打开网页首页
    //driver.findElement(By.xpath(".//*[@id='u1']/a[7]")).click(); //点击"登录”链接打开登录窗口
    
    LoginPage.getUserNameElement(driver).clear();
    LoginPage.getUserNameElement(driver).sendKeys("monkey1");
    
    LoginPage.getPasswordElement(driver).clear();;
    LoginPage.getPasswordElement(driver).sendKeys("monkey1");
    
    LoginPage.getSubmitElement(driver).click();
    
    Thread.sleep(6000);
    //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    
  }
  
  public static void loginWithVerifyCode(WebDriver driver,String baseUrl) throws Exception {
   	    driver.get(baseUrl);  //打开网页首页
	    //driver.findElement(By.xpath(".//*[@id='u1']/a[7]")).click(); //点击"登录”链接打开登录窗口
	    	    
	    LoginPage.getUserNameElement(driver).clear();
	    LoginPage.getUserNameElement(driver).sendKeys("monkey1");
	    
	    LoginPage.getPasswordElement(driver).clear();;
	    LoginPage.getPasswordElement(driver).sendKeys("monkey1");
	    
        WebElement element = LoginPage.getVerifyCodeImgElement(driver);
	    EasyOcrDao.getAndInputCorrectVerifyCode(driver, element, Config.picFilePath, Config.picFileDirAfterClean); //通过Dao层（EasyOcrDao）获取并输入"正确的"验证码
	    
	    Thread.sleep(2000);
	    
	    LoginPage.getSubmitElement(driver).click();	    
	    Thread.sleep(5000);
	    
  }
  
  public static void loginByCsv(WebDriver driver,String baseUrl,String csvFilePath) throws Exception {        
  	  	ArrayList<String[]> csvList = new ArrayList<String[]>();
	  	csvList = CsvDao.getCsvList(csvFilePath);  //通过Dao层读取csv文件
	    
	    driver.get(baseUrl);  //打开网页首页
	    //driver.findElement(By.xpath(".//*[@id='u1']/a[7]")).click(); //点击"登录”链接打开登录窗口
	    
	    LoginPage.getUserNameElement(driver).clear();
	    LoginPage.getUserNameElement(driver).sendKeys(csvList.get(0)[0]);
	    
	    LoginPage.getPasswordElement(driver).clear();
	    LoginPage.getPasswordElement(driver).sendKeys(csvList.get(0)[1]);
	    
	    LoginPage.getSubmitElement(driver).click();	    
	    Thread.sleep(5000);
	    
  }
  
  public static void loginWithVerifyCodeByCsv(WebDriver driver,String baseUrl,String csvFilePath) throws Exception {        
	  	ArrayList<String[]> csvList = new ArrayList<String[]>();
	  	csvList = CsvDao.getCsvList(csvFilePath);  //通过Dao层读取csv文件
	 	    
	    driver.get(baseUrl);  //打开网页首页
	    //driver.findElement(By.xpath(".//*[@id='u1']/a[7]")).click();
        
	    LoginPage.getUserNameElement(driver).clear();
	    LoginPage.getUserNameElement(driver).sendKeys(csvList.get(0)[0]);
	    
	    LoginPage.getPasswordElement(driver).clear();
	    LoginPage.getPasswordElement(driver).sendKeys(csvList.get(0)[1]);
  
        WebElement element = LoginPage.getVerifyCodeImgElement(driver);
	    EasyOcrDao.getAndInputCorrectVerifyCode(driver, element, Config.picFilePath, Config.picFileDirAfterClean); //通过Dao层（EasyOcrDao）获取并输入"正确的"验证码
	    
	    Thread.sleep(2000);
	    
	    LoginPage.getSubmitElement(driver).click();	    
	    Thread.sleep(5000);
	    
  }*/
  
  public static void loginByExcel(WebDriver driver, String baseUrl, String excelFilePath) throws Exception {
	  	//Sheet excelSheet = null;
	  	//excelSheet = PoiExcelDao.getExcelSheet(excelFilePath);  //通过Dao层读取excel文件
	 	    
	    driver.get(baseUrl);  //打开网页首页
	    //driver.findElement(By.xpath(".//*[@id='u1']/a[7]")).click();

	    LoginPage loginPage = new LoginPage();

	    loginPage.getUserNameElement(driver).clear();
	    loginPage.getUserNameElement(driver).sendKeys(PoiExcelDao.getCellContent(excelFilePath, 0, 1));
	    
	    loginPage.getPasswordElement(driver).clear();
	    loginPage.getPasswordElement(driver).sendKeys(PoiExcelDao.getCellContent(excelFilePath, 1, 1));
	    
	    loginPage.getSubmitElement(driver).click();
	    Thread.sleep(5000);
	    
}

	/**
	 * 打开HomePage
	 * @param
	 */
	public static void switchToHomePage(WebDriver driver) {
		driver.get(Config.baseUrl2);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
  
  /*5public static void loginWithVerifyCodeByExcel(WebDriver driver,String baseUrl,String excelFilePath) throws Exception {
	  	//Sheet excelSheet = null;
	  	//excelSheet = PoiExcelDao.getExcelSheet(excelFilePath, 0);  //通过Dao层读取excel文件
	 	    
	    driver.get(baseUrl);  //打开网页首页
	    //driver.findElement(By.xpath(".//*[@id='u1']/a[7]")).click();
      
	    LoginPage.getUserNameElement(driver).clear();
	    LoginPage.getUserNameElement(driver).sendKeys(PoiExcelDao.getCellContent(excelFilePath, 0, 1));
	    
	    LoginPage.getPasswordElement(driver).clear();
	    LoginPage.getPasswordElement(driver).sendKeys(PoiExcelDao.getCellContent(excelFilePath, 1, 1));

	    WebElement element = LoginPage.getVerifyCodeImgElement(driver);
	    EasyOcrDao.getAndInputCorrectVerifyCode(driver, element, Config.picFilePath, Config.picFileDirAfterClean); //通过Dao层（EasyOcrDao）获取并输入"正确的"验证码
	    
	    Thread.sleep(2000);
	    
	    LoginPage.getSubmitElement(driver).click();	    
	    Thread.sleep(5000);
	    
  }*/
  
  /**
   * 通过Cookie登陆
   * @param driver
   * @param baseUrl
   * @param cookieName
   * @param cookieValue
   * @param cookieName2
   * @param cookieValue2
   * @throws Exception
   */
  public static void loginByCookie(WebDriver driver,String baseUrl,String cookieName,String cookieValue, String cookieName2, String cookieValue2) throws Exception {
	    driver.get(baseUrl);  //打开网页首页

	    driver.manage().deleteAllCookies();
	    
		Cookie cookie = new Cookie(cookieName, cookieValue);  //在F12->存储->Cookie中去找
		driver.manage().addCookie(cookie);
		Cookie cookie2 = new Cookie(cookieName2, cookieValue2);  //在F12->存储->Cookie中去找
		driver.manage().addCookie(cookie2);
		driver.navigate().refresh();
	    Thread.sleep(5000);
	    //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	    
	    //return driver;
  }

	public static void logout(WebDriver driver) throws Exception {
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("/html/body/section/main/header/header/div[1]/div[2]/div/p/i"))).perform();//要用a.必须放在一个类的方法中。
		driver.findElement(By.className("Dropdown")).findElement(By.id("userOut")).click();
		Thread.sleep(3000);
	}

  /*//搜索，再打开链接页面中的登出
  public static void logoutBaidu(WebDriver driver) throws Exception {
	  Actions a = new Actions(driver);	
	  a.moveToElement(driver.findElement(By.id("user-name"))).perform();//要用a.必须放在一个类的方法中。
	  driver.findElement(By.className("sub-list")).findElement(By.id("userbar-logout")).click();
	  Thread.sleep(3000);
  }

  public static void logoutBaiduInSearchPage(WebDriver driver) throws Exception {
	  Actions a = new Actions(driver);	
	  a.moveToElement(driver.findElement(By.id("user"))).perform();//要用a.必须放在一个类的方法中。
	  driver.findElement(By.className("usermenu")).findElement(By.className("logout")).click();
	  Thread.sleep(3000);
  }
  
 //有dialog对话框的登出
  public static void logoutBaiduInHomePage(WebDriver driver) throws Exception {
	  Actions a = new Actions(driver);	
	  a.moveToElement(driver.findElement(By.id("s_username_top"))).perform();//要用a.必须放在一个类的方法中。
	  //去掉一级定位findElement(By.id("s_user_name_menu"))后，还是可以正常运行
	  driver.findElement(By.className("quit")).click();
	  Thread.sleep(3000);	
	  driver.findElement(By.xpath(".//*[@id='tip_con_wrap']/div[3]/a[3]")).click(); //验证用xpath成功
	  //driver.findElement(By.id("tip_con_wrap")).findElement(By.className("s-btn btn-ok")).click(); //不成功
	  Thread.sleep(3000);	  
  }*/
  
  //@AfterTest
  public static void tearDown(WebDriver driver) throws Exception {
    driver.quit();
    //静态方法中，默认verificationErrorString为static,所以必须将verificationErrors定义为类中全局staic类型
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  public static void handleException(Exception e) {
	  logger.error("[logger] 异常信息为：", e);
	  //Assert.assertTrue(false);
	  throw new AssertionError(e);
  }
  
}

