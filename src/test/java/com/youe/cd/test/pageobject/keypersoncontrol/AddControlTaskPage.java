package com.youe.cd.test.pageobject.keypersoncontrol;

import com.youe.cd.test.pageobject.BasePage;

public class AddControlTaskPage extends BasePage{
    private String xmlPath = "src/test/java/com/youe/cd/test/pageobjectconfig/keypersoncontrol/AddControlTaskPage.xml";

    public AddControlTaskPage() {
        //工程内读取对象库文件
        setXmlPath(xmlPath);
        getLocatorMap();
    }
}
