package com.youe.cd.test.pageobject.login;

import com.youe.cd.test.util.Locator;
import com.youe.cd.test.util.Locator.ByType;
import com.youe.cd.test.util.XmlReadUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage {

	//protected 只在本包之内有权限，可访问
	//protected  WebDriver driver;
	//protected Log log;

	//定位信息图（对象库存储结构）
	protected HashMap<String,Locator>  locatorMap;
	public String xmlPath = null;
	public InputStream path_inputStream_1;
	public InputStream path_inputStream_2;

	//Log log=new Log(this.getClass());
	Logger logger = LoggerFactory.getLogger(this.getClass().getSuperclass());

	public void setXmlPath(String xmlPath) {
		this.xmlPath = xmlPath;
	}

	public void setXmlObjectPathForLocator(InputStream path_inputStream) {
		this.path_inputStream_1 = path_inputStream;
	}

	public void setXmlObjectPathForPageURL(InputStream path_inputStream) {
		this.path_inputStream_2 = path_inputStream;
	}

	public BasePage() {


	}

	public void getLocatorMap() {
		XmlReadUtil xmlReadUtil=new XmlReadUtil();
		try {
			if((xmlPath == null||xmlPath.equals(""))) {
				locatorMap = xmlReadUtil.readXMLDocument(path_inputStream_1, this.getClass().getCanonicalName());}
			else {
				locatorMap = xmlReadUtil.readXMLDocument(xmlPath, this.getClass().getCanonicalName());
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * 从对象库获取定位信息
	 * @param locatorName 对象库名字
	 * @return
	 * @throws IOException
	 */
	public Locator getLocator(String locatorName)
	{
		Locator locator;
		/**
		 * 在对象库通过对象名字查找定位信息
		 */
		locator = locatorMap.get(locatorName);
		/**
		 * 加入对象库，找不到该定位信息，就创建一个定位信息
		 */
		if(locator == null)
		{
			logger.error("没有找到"+locatorName+"页面元素");
		}
		return locator;

	}

	public By getByByLocator (Locator locator){
		switch(locator.getByType()){
			case id:
				return By.id(locator.getElement());
			case cssSelector:
				return By.cssSelector(locator.getElement());
			case name:
				return By.name(locator.getElement());
			case xpath:
				return By.xpath(locator.getElement());
			case className:
				return By.className(locator.getElement());
			case tagName:
				return By.tagName(locator.getElement());
			case linkText:
				return By.linkText(locator.getElement());
			case partialLinkText:
				return By.partialLinkText(locator.getElement());
			//return null也可以放到switch外面
			default:
				return null;
		}

	}

	public By getByByLocatorName(String locatorName) {
		Locator locator = getLocator(locatorName);
		By by = getByByLocator(locator);

		return by;
	}

	public WebElement getElement(WebDriver driver, String locatorName) {
		WebElement element = null;

		By by = getByByLocatorName(locatorName);
		element = driver.findElement(by);

		return element;
	}

	public String getPageURL() {
		String pageURL=null;
		try {
			if(xmlPath==null||xmlPath.equals("")) {
				pageURL=XmlReadUtil.getXmlPageURL(path_inputStream_1, this.getClass().getCanonicalName());
			}
			else {
				pageURL=XmlReadUtil.getXmlPageURL(xmlPath, this.getClass().getCanonicalName());
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return pageURL;
	}


}
