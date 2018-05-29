package com.youe.cd.test.pageobject.login;

import com.youe.cd.test.util.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class LoginPage extends BasePage {
	//private WebElement element = null;
	
/*	public static WebElement getUserNameElement(WebDriver driver) {
		element = driver.findElement(By.id("TANGRAM__PSP_10__userName"));
		return element;
	}
	
	public static WebElement getPasswordElement(WebDriver driver) {
		element = driver.findElement(By.id("TANGRAM__PSP_10__password"));
		return element;
	}

	public static WebElement getVerifyCodeElement(WebDriver driver) {
		element = driver.findElement(By.id("TANGRAM__PSP_10__verifyCode"));
		return element;
	}
	
	public static WebElement getVerifyCodeImgElement(WebDriver driver) {
		element = driver.findElement(By.id("TANGRAM__PSP_10__verifyCodeImg"));
		return element;
	}
	
	public static WebElement getSubmitElement(WebDriver driver) {
		element = driver.findElement(By.id("TANGRAM__PSP_10__submit"));
		return element;
	}*/

//*******************************************

	/*public static WebElement getUserNameElement(WebDriver driver) {
		element = driver.findElement(By.id("username"));
		return element;
	}
	
	public static WebElement getPasswordElement(WebDriver driver) {
		element = driver.findElement(By.id("password"));
		return element;
	}

	public static WebElement getVerifyCodeElement(WebDriver driver) {
		element = driver.findElement(By.id("vcode"));
		return element;
	}
	
	public static WebElement getVerifyCodeImgElement(WebDriver driver) {
		element = driver.findElement(By.id("valicodeImg"));
		return element;
	}
	
	//获取输入错误验证后的错误提示Element
	public static WebElement getErrorHintElement(WebDriver driver) {
		element = driver.findElement(By.className("errorHint"));
		return element;
	}
	
	public static WebElement getSubmitElement(WebDriver driver) {
		element = driver.findElement(By.xpath(".//*[@id='login_form']/div/div[2]/div[3]/button"));
		return element;
	}*/

//***********************************************

	/*public static WebElement getUserNameElement(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/section/section/div/form/div[1]/div/div[1]/input"));
		return element;
	}

	public static WebElement getPasswordElement(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/section/section/div/form/div[2]/div/div/input"));
		return element;
	}

	public static WebElement getVerifyCodeElement(WebDriver driver) {
		element = driver.findElement(By.id("vcode"));
		return element;
	}

	public static WebElement getVerifyCodeImgElement(WebDriver driver) {
		element = driver.findElement(By.id("valicodeImg"));
		return element;
	}

	//获取输入错误验证后的错误提示Element
	public static WebElement getErrorHintElement(WebDriver driver) {
		element = driver.findElement(By.className("errorHint"));
		return element;
	}

	public static WebElement getSubmitElement(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/section/section/div/form/div[3]/div/button"));
		return element;
	}*/

	private String xmlPath = "src/test/java/com/youe/cd/test/pageobjectconfig/login/LoginPage.xml";

	public LoginPage() {
		//工程内读取对象库文件
		setXmlPath(xmlPath);
		getLocatorMap();
	}

	public WebElement getUserNameElement(WebDriver driver) throws IOException {
		WebElement element = getElement(driver, "userName");
		return element;
	}

	public WebElement getPasswordElement(WebDriver driver) throws IOException {
		WebElement element = getElement(driver, "password");
		return element;
	}

	public WebElement getVerifyCodeImgElement(WebDriver driver) throws IOException {
		WebElement element = getElement(driver, "verifyCodeImg");
		return element;
	}

	public WebElement getSubmitElement(WebDriver driver) throws IOException {
		WebElement element = getElement(driver, "submit");
		return element;
	}


	
}
