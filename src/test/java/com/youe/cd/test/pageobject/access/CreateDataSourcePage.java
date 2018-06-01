package com.youe.cd.test.pageobject.access;

import com.youe.cd.test.pageobject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class CreateDataSourcePage extends BasePage {
    private String xmlPath = "src/test/java/com/youe/cd/test/pageobjectconfig/access/CreateDataSourcePage.xml";

    public CreateDataSourcePage() {
        //工程内读取对象库文件
        setXmlPath(xmlPath);
        getLocatorMap();
    }

    /*3public WebElement getAddDSButtonElement(WebDriver driver) throws IOException {
        WebElement element = getElement(driver, "addDSButton");
        return element;
    }

    public WebElement getDSCategoryElement(WebDriver driver) throws IOException {
        WebElement element = getElement(driver, "DSCategory");
        return element;
    }

    public WebElement getDSCategoryRelationDBElement(WebDriver driver) throws IOException {
        WebElement element = getElement(driver, "DSCategoryRelationDB");
        return element;
    }

    public WebElement getDSCategoryStructuralStoreElement(WebDriver driver) throws IOException {
        WebElement element = getElement(driver, "DSCategoryStructuralStore");
        return element;
    }

    public WebElement getDSTypeElement(WebDriver driver) throws IOException {
        WebElement element = getElement(driver, "DSType");
        return element;
    }

    public WebElement getDSTypeMYSQLElement(WebDriver driver) throws IOException {
        WebElement element = getElement(driver, "DSTypeMYSQL");
        return element;
    }

    public WebElement getDSTypeORACLEElement(WebDriver driver) throws IOException {
        WebElement element = getElement(driver, "DSTypeORACLE");
        return element;
    }

    public WebElement getDSNameElement(WebDriver driver) throws IOException {
        WebElement element = getElement(driver, "DSName");
        return element;
    }

    public WebElement getDSDescriptionElement(WebDriver driver) throws IOException {
        WebElement element = getElement(driver, "DSDescription");
        return element;
    }

    public WebElement getJDBCUrlElement(WebDriver driver) throws IOException {
        WebElement element = getElement(driver, "JDBCUrl");
        return element;
    }

    public WebElement getJDBCUserNameElement(WebDriver driver) throws IOException {
        WebElement element = getElement(driver, "JDBCUserName");
        return element;
    }

    public WebElement getJDBCPasswordElement(WebDriver driver) throws IOException {
        WebElement element = getElement(driver, "JDBCPassword");
        return element;
    }

    public WebElement getTestConnectionElement(WebDriver driver) throws IOException {
        WebElement element = getElement(driver, "testConnection");
        return element;
    }

    public WebElement getConfirmButtonElement(WebDriver driver) throws IOException {
        WebElement element = getElement(driver, "confirmButton");
        return element;
    }*/

}
