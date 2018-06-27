package com.youe.cd.test.util.action;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ElementAction extends BaseAction {
    private static boolean acceptNextAlert = true;

    //private static Logger logger = LoggerFactory.getLogger(ElementAction.class);

    /**
     * 隐式等待, 默认30秒
     * @param
     */
    public static void implicitlyWaitFor() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    /**
     * 隐式等待（多少秒）
     * @param
     * waitTime 等待时间（秒）
     */
    public static void implicitlyWaitFor(int waitTime) {
        driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
    }

    /**
     * 多窗口切换
     * @param i 第几个窗口
     */
    public static void switchToWindow(int i) {
        String[] handls=new String[driver.getWindowHandles().size()];
        driver.getWindowHandles().toArray(handls);
        driver.switchTo().window(handls[i]);
    }

    /**
     * 切换到最后一个窗口
     * @param
     */
    public static void switchToLastWindow() {
        Set<String> allhandles = driver.getWindowHandles();
        Iterator<String> it = allhandles.iterator();
        while(it.hasNext()) {
            String currenthandle = it.next(); //首次使用指向第一个String handle,即从0开始
            System.out.println("currenthandle is " + currenthandle);
            //if (!homehandle.equals(currenthandle)) {
            driver.switchTo().window(currenthandle);
            //break;
            //}
        }
        logger.info("[logger] 切换到最后一个窗口成功");
    }

    /**
     * 切换frame/iframe框架
     * @param by  元素定位by
     */
    public void switchToFrame(By by) {
        WebElement frameElement = driver.findElement(by);
        driver.switchTo().frame(frameElement);
    }
    /**
     * 切回默认窗口框架
     */
    public void switchToDefaultFrame() {
        driver.switchTo().defaultContent();
    }

    /**
     * 判断元素是否存在
     * @param
     * @param by
     * @return
     */
    public static boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            logger.info("元素存在" + by.toString());
            return true;
        } catch (NoSuchElementException e) {
            logger.info("没有这个元素(不存在): " + by.toString());
            return false;
        }
    }

    /**
     * 判断元素是否显示（或隐藏）
     * @param
     * @param by
     * @return 返回: true显示或false隐藏
     */
    public static boolean isElementDisplayed(By by) {
        WebElement webElement = driver.findElement(by);
        webElement.isDisplayed();

        return webElement.isDisplayed();  //显示或隐藏
    }

    /**
     * 等待waitTime秒（建议30秒左右），让元素可见（相对于隐藏）
     * @param
     * @param by
     * @param waitTime 等待时间（秒）
     */
    public static void waitElementDisplay(By by, int waitTime) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, waitTime);
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(by))).isDisplayed();
    }

    public static boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            logger.info("Alert存在");
            return true;
        } catch (NoAlertPresentException e) {
            logger.error("Alert不存在");
            return false;
        }
    }

    public static void alertConfirm() {
        try {
            Alert alert= driver.switchTo().alert();
            alert.accept();
            logger.info("Alert确认成功");
        } catch (NoAlertPresentException e) {
            logger.error("找不到Alert");
            throw e;
        }
    }

    public static void alertDismiss() {
        try {
            Alert alert= driver.switchTo().alert();
            alert.dismiss();
            logger.info("Alert取消成功");
        } catch (NoAlertPresentException e) {
            logger.error("找不到Alert");
            throw e;
        }
    }

    public static String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } catch (NoAlertPresentException e) {
            logger.error("找不到Alert");
            throw e;
        } finally{
            acceptNextAlert = true;
        }
    }



    public static void selectByText(By by, String text) {
        try {
            WebElement webElement = driver.findElement(by);
            Select select = new Select(webElement);

            try {
                select.selectByVisibleText(text);
                logger.info("成功选择下拉列表中的：" + text);
            } catch (NoSuchElementException e) {
                logger.info("找不到下拉值，选择下拉列表失败，Text为：" + text);
                throw e;
            }
        } catch (NoSuchElementException e) {
            logger.error("找不到(下拉列表)元素，选择下拉列表失败，Text为：" + text);
            throw e;
        }

    }

    public static void selectByValue(By by, String value) {
        Select select;
        try {
            WebElement webElement = driver.findElement(by);
            select = new Select(webElement);
            logger.info("选择select标签成功");
        } catch (NoSuchElementException e) {
            logger.error("找不到下拉列表元素, value为：" + value);
            throw e;
        }

        try {
            select.selectByValue(value);
            logger.info("选择下拉列表中的value: " + value + "成功");
        } catch (NoSuchElementException e) {
            logger.error("找不到下拉列表中的value元素，下拉列表中的value: " + value + "失败");
            throw e;
        }
    }

    public static void selectByIndex(By by, int index) {
        Select select;
        try {
            WebElement webElement = driver.findElement(by);
            select = new Select(webElement);
            logger.info("选择select标签成功");
        } catch (NoSuchElementException e) {
            logger.error("找不到下拉列表元素");
            throw e;
        }

        try {
            select.selectByIndex(index);
            logger.info("选择下拉列表中的index: " + index + "成功");
        } catch (NoSuchElementException e) {
            logger.error("找不到下拉列表中的index元素，下拉列表中的index: " + index + "失败");
            throw e;
        }
    }

    /**
     * 鼠标移动到元素
     * @param
     * @param by 元素定位by
     */
    public static void moveToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).perform();
    }

    /**
     * 鼠标悬停操作
     * @param
     * @param by
     */
    public static void clickAndHold(By by) {
        Actions actions = new Actions(driver);
        actions.clickAndHold(driver.findElement(by)).perform();
    }

    /**
     * 鼠标左击(通过Actions类）操作
     * @param
     * @param by
     */
    public static void clickLeft(By by) {
        Actions actions = new Actions(driver);
        actions.click(driver.findElement(by)).perform();
    }

    /**
     * 鼠标右击(通过Actions类）操作
     * @param
     * @param by
     */
    public static void clickRight(By by) {
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(by)).perform();
    }

    /**
     * 鼠标双击(通过Actions类）操作
     * @param
     * @param by
     */
    public static void clickDouble(By by) {
        Actions actions = new Actions(driver);
        actions.doubleClick(driver.findElement(by)).perform();
    }

    /**
     * 通过By by定位一组元素(复选框)，并全选
     * @param
     * @param by
     */
    public static void checkBoxCheckAll(By by) throws Exception {
        List<WebElement> checkBoxs = driver.findElements(by);  //通过by定位一组元素
        for(WebElement checkBox:checkBoxs) {  //使用循环全选
            checkBox.click();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            //e.printStackTrace();
            logger.error("[logger] 异常信息为: ", e);
            throw e;
        }
    }


    /**
     * 显式等待 判断页面是否完全加载完成
     * @param time 以秒为单位?
     */
    public static void waitPageLoadComplete(long time)
    {
        ExpectedCondition<Boolean> pageLoad= new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, time*1000);
        wait.until(pageLoad);
    }

    public static void executeJS(WebDriver driver, String js) {
        ((JavascriptExecutor) driver).executeScript(js);
        System.out.println("执行JS脚本："+js);

    }


}
