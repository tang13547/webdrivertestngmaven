package com.youe.cd.test.pageobject.home;

import com.youe.cd.test.pageobject.BasePage;

public class BusinessPage extends BasePage {
    private String xmlPath = "src/test/java/com/youe/cd/test/pageobjectconfig/home/BusinessPage.xml";

    public BusinessPage() {
        //工程内读取对象库文件
        setXmlPath(xmlPath);
        getLocatorMap();
    }
}
