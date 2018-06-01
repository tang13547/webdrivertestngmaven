package com.youe.cd.test.pageobject.access;

import com.youe.cd.test.pageobject.BasePage;

public class CreateTaskPage extends BasePage {
    private String xmlPath = "src/test/java/com/youe/cd/test/pageobjectconfig/access/CreateTaskPage.xml";

    public CreateTaskPage() {
        //工程内读取对象库文件
        setXmlPath(xmlPath);
        getLocatorMap();
    }



}
