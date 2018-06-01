package com.youe.cd.test.util.action;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ActionAdaptor {
    public static Logger logger = LoggerFactory.getLogger(ActionAdaptor.class);

    public static void clickBySpanText(WebDriver driver, String text) {
        try {
            String xpathStr = "//span[text()='" + text + "']";
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
     * createDataSource页面下拉选择DSCategory, 如："关系型数据库"、"半结构化存储"等；或createDataSource页面下拉选择DSType, 如："MYSQL"、"ORACLE"；或createTask页面选择DSType,如："MYSQL"、"ORACLE";
     * @param driver
     * @param text 下拉选择的text, 如："关系型数据库"、"半结构化存储"
     */
    public static void clickBySpanTextForDS(WebDriver driver, String text) {
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

    }
    /**
     * 创建任务页面：选择表
     * @param driver
     * @param text 下拉选择的text, 如："testtable"
     */
    public static void clickByDivTextForChooseTable(WebDriver driver, String text) {
        try {
            String xpathStr = "//div[text()='" + text + "']/../../td[1]";

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
