package com.youe.cd.test.util.action;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseAction extends ActionAdaptor {
    //public static Logger logger = LoggerFactory.getLogger(BaseAction.class);

    public static void back(WebDriver driver) {
        driver.navigate().back();
        logger.info("浏览器后退操作");
    }

    public static void forward(WebDriver driver) {
        driver.navigate().forward();
        logger.info("浏览器前进操作");
    }

    public static void refresh(WebDriver driver) {
        driver.navigate().refresh();
        logger.info("浏览器刷新操作");
    }

    public static void sendKeys(WebDriver driver, By by, String contentStr) {
        driver.findElement(by).sendKeys(contentStr);
    }
    /**
     * 输入空格
     * @param driver
     * @param by
     */
    public static void sendKeys_space(WebDriver driver, By by) {
        driver.findElement(by).sendKeys(Keys.BACK_SPACE);
    }
    /**
     * 全选(输入框）
     * @param driver
     * @param by
     */
    public static void sendKeys_ctrl_a(WebDriver driver, By by) {
        driver.findElement(by).sendKeys(Keys.CONTROL, "a");
    }

    /**
     * 复制(输入框）
     * @param driver
     * @param by
     */
    public static void sendKeys_ctrl_c(WebDriver driver, By by) {
        driver.findElement(by).sendKeys(Keys.CONTROL, "c");
    }
    /**
     * 剪切(输入框)
     * @param driver
     * @param by
     */
    public static void sendKeys_ctrl_x(WebDriver driver, By by) {
        driver.findElement(by).sendKeys(Keys.CONTROL, "x");
    }

    /**
     * 粘贴(内容到输入框)
     * @param driver
     * @param by
     */
    public static void sendKeys_ctrl_v(WebDriver driver, By by) {
        driver.findElement(by).sendKeys(Keys.CONTROL, "v");
    }
    /**
     * 回车
     * @param driver
     * @param by
     */
    public static void sendKeys_ctrl_enter(WebDriver driver, By by) {
        driver.findElement(by).sendKeys(Keys.ENTER);
    }

}
