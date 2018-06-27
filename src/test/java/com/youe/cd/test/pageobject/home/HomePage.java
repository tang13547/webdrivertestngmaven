package com.youe.cd.test.pageobject.home;

import com.youe.cd.test.pageobject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class HomePage extends BasePage {
    private String xmlPath = "src/test/java/com/youe/cd/test/pageobjectconfig/home/HomePage.xml";

    public HomePage() {
        //工程内读取对象库文件
        setXmlPath(xmlPath);
        getLocatorMap();
    }

}
