package com.youe.cd.test.pageobject.loginmail;

import com.youe.cd.test.pageobject.BasePage;

public class LoginMailPage extends BasePage {

	private String xmlPath = "src/test/java/com/youe/cd/test/pageobjectconfig/loginmail/LoginMailPage.xml";

	public LoginMailPage() {
		//工程内读取对象库文件
		setXmlPath(xmlPath);
		getLocatorMap();
	}
	
}
