package com.youe.cd.test.util.action;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseAction extends ActionAdaptor {
    //public static Logger logger = LoggerFactory.getLogger(BaseAction.class);

    public static void back() {
        driver.navigate().back();
        logger.info("浏览器后退操作");
    }

    public static void forward() {
        driver.navigate().forward();
        logger.info("浏览器前进操作");
    }

    public static void refresh() {
        driver.navigate().refresh();
        logger.info("浏览器刷新操作");
    }

    public static void sendKeys(By by, String contentStr) {
        driver.findElement(by).sendKeys(contentStr);
    }
    /**
     * 输入空格
     * @param
     * @param by
     */
    public static void sendKeys_space(By by) {
        driver.findElement(by).sendKeys(Keys.BACK_SPACE);
    }
    /**
     * 全选(输入框）
     * @param
     * @param by
     */
    public static void sendKeys_ctrl_a(By by) {
        driver.findElement(by).sendKeys(Keys.CONTROL, "a");
    }

    /**
     * 复制(输入框）
     * @param
     * @param by
     */
    public static void sendKeys_ctrl_c(By by) {
        driver.findElement(by).sendKeys(Keys.CONTROL, "c");
    }
    /**
     * 剪切(输入框)
     * @param
     * @param by
     */
    public static void sendKeys_ctrl_x(By by) {
        driver.findElement(by).sendKeys(Keys.CONTROL, "x");
    }

    /**
     * 粘贴(内容到输入框)
     * @param
     * @param by
     */
    public static void sendKeys_ctrl_v(By by) {
        driver.findElement(by).sendKeys(Keys.CONTROL, "v");
    }
    /**
     * 回车
     * @param
     * @param by
     */
    public static void sendKeys_ctrl_enter(By by) {
        driver.findElement(by).sendKeys(Keys.ENTER);
    }

}
