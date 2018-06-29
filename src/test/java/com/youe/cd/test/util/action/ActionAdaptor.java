package com.youe.cd.test.util.action;

import com.youe.cd.test.controller.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

//import static com.youe.cd.test.controller.TestBase.driver;

public class ActionAdaptor extends TestBase {
    public static Logger logger = LoggerFactory.getLogger(ActionAdaptor.class);

    public static void clickBySpanText(String text) {
        List<WebElement> webElementList = null;
        WebElement webElement = null;

        try {
            String xpathStr = "//span[text()='" + text + "']";
            //String xpathStr = "//span[contains(text(),'" + text + "')]";
            webElementList = driver.findElements(By.xpath(xpathStr));

            for(WebElement ele:webElementList) {
                if(ele.isEnabled()) {
                    webElement = ele;
                }
            }

            //WebElement webElement = driver.findElement(By.xpath(xpathStr));

            //Select select = new Select(webElement);

            try {
                //select.selectByVisibleText(text);
                webElement.click();
                logger.info("成功选择(click)下拉列表中的：" + text);
            } catch (NoSuchElementException e) {
                logger.info("找不到下拉值，选择下拉列表失败，Text为：" + text);
                throw e;
            }
        } catch (NoSuchElementException e) {
            logger.error("找不到(下拉列表)元素，选择下拉列表失败，Text为：" + text);
            throw e;
        }

    }
    /**
     * createDataSource页面下拉选择DSCategory, 如："关系型数据库"、"半结构化存储"等；或createDataSource页面下拉选择DSType, 如："MYSQL"、"ORACLE"；或createTask页面选择DSType,如："MYSQL"、"ORACLE";xxftp自动建表配置表时也可用：int,date,varchar,datetime,text等:
     * @param
     * @param text 下拉选择的text, 如："关系型数据库"、"半结构化存储"
     */
    /*public static void clickBySpanTextForDS(String text) {
        try {
            String xpathStr = "//div[not(contains(@style,'display: none'))]/div/div/ul/li/span[text()='" + text + "']";

            WebElement webElement = driver.findElement(By.xpath(xpathStr));

            //Select select = new Select(webElement);

            try {
                //select.selectByVisibleText(text);
                webElement.click();
                logger.info("成功选择(click)下拉列表中的：" + text);
            } catch (NoSuchElementException e) {
                logger.info("找不到下拉值，选择下拉列表失败，Text为：" + text);
                throw e;
            }
        } catch (NoSuchElementException e) {
            logger.error("找不到(下拉列表)元素，选择下拉列表失败，Text为：" + text);
            throw e;
        }

    }*/

    public static void clickByDivText(String text) {
        try {
            String xpathStr = "//div[text()='" + text + "']";
            //String xpathStr = "//span[contains(text(),'" + text + "')]";
            WebElement webElement = driver.findElement(By.xpath(xpathStr));

            //Select select = new Select(webElement);

            try {
                //select.selectByVisibleText(text);
                webElement.click();
                logger.info("成功选择(click)下拉列表中的：" + text);
            } catch (NoSuchElementException e) {
                logger.info("找不到下拉值，选择下拉列表失败，Text为：" + text);
                throw e;
            }
        } catch (NoSuchElementException e) {
            logger.error("找不到(下拉列表)元素，选择下拉列表失败，Text为：" + text);
            throw e;
        }

    }

    /**
     * 创建任务页面：选择表
     * @param
     * @param text 下拉选择的text, 如："testtable"
     * @param externalPath  后掊的额外路径，加选择创建任务过程中的选择表使用：../../td[1]
     */
    public static void clickBySpanTextWithExternalPath(String text, String externalPath) {
        try {
            String xpathStr = "//span[text()='" + text + "']/" + externalPath;

            WebElement webElement = driver.findElement(By.xpath(xpathStr));

            //Select select = new Select(webElement);

            try {
                //select.selectByVisibleText(text);
                webElement.click();
                logger.info("成功选择(click)下拉列表中的：" + text);
            } catch (NoSuchElementException e) {
                logger.info("找不到下拉值，选择下拉列表失败，Text为：" + text);
                throw e;
            }
        } catch (NoSuchElementException e) {
            logger.error("找不到(下拉列表)元素，选择下拉列表失败，Text为：" + text);
            throw e;
        }

    }

    /**
     * 创建任务页面：选择表
     * @param
     * @param text 下拉选择的text, 如："testtable"
     * @param externalPath  后掊的额外路径，加选择创建任务过程中的选择表使用：../../td[1]
     */
    public static void clickByDivTextWithExternalPath(String text, String externalPath) {
        try {
            String xpathStr = "//div[text()='" + text + "']/" + externalPath;

            WebElement webElement = driver.findElement(By.xpath(xpathStr));

            //Select select = new Select(webElement);

            try {
                //select.selectByVisibleText(text);
                webElement.click();
                logger.info("成功选择(click)下拉列表中的：" + text);
            } catch (NoSuchElementException e) {
                logger.info("找不到下拉值，选择下拉列表失败，Text为：" + text);
                throw e;
            }
        } catch (NoSuchElementException e) {
            logger.error("找不到(下拉列表)元素，选择下拉列表失败，Text为：" + text);
            throw e;
        }

    }

}
