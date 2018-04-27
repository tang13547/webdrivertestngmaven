package com.youe.cd.test.util.verify;

import com.youe.cd.test.util.Config;
import com.youe.cd.test.util.ScreenShotUtil;
import com.youe.cd.test.util.listener.ScreenShotOnFailureListener;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Verify {
    public static boolean flag = true;
    public static StringBuffer errorBuffer = new StringBuffer();

    public static WebDriver driver;
    public static String className;
    public static String methodName;

    public static void verifyEquals(Object actual, Object expected) {
        try {
            errorBuffer.delete(0, errorBuffer.length());  //先请空buffer
            Assert.assertEquals(actual, expected);
            //return true;
        } catch (AssertionError e) {
            //增加verify失败时的自动截图
            driver = ScreenShotOnFailureListener.driver;
            className = ScreenShotOnFailureListener.className;
            methodName = ScreenShotOnFailureListener.methodName;
            ScreenShotUtil.takeScreenShot(driver, className, methodName+ "_" + "Verify", Config.screenShotPath);

            errorBuffer.append(e.getMessage() + "\n");
            flag = false;
            //return false;
        }

        /*if(errorBuffer.length() > 0) {
            throw new AssertionError(errorBuffer.toString());
        }*/
    }

    public static void verifyEquals(Object actual, Object expected, String message) {
        try {
            errorBuffer.delete(0, errorBuffer.length());  ////先请空buffer
            Assert.assertEquals(actual, expected, message);
            //return true;
        } catch (AssertionError e) {
            //增加verify失败时的自动截图
            driver = ScreenShotOnFailureListener.driver;
            className = ScreenShotOnFailureListener.className;
            methodName = ScreenShotOnFailureListener.methodName;
            ScreenShotUtil.takeScreenShot(driver, className, methodName+ "_" + "Verify", Config.screenShotPath);

            errorBuffer.append(e.getMessage() + "\n");
            flag = false;
            //return false;
        }

        /*if(errorBuffer.length() > 0) {
            throw new AssertionError(errorBuffer.toString());
        }*/
    }

    /*public static boolean verifyEquals(Object actual, Object expected, String message) {
        try {
            Assert.assertEquals(actual, expected, message);
            return true;
        } catch (Error e) {
            flag = false;
            return false;
        }
    }*/

    /**
     * 第二步：在代码最后，通过errorBuffer抛出断言失败AssertionError异常(错误)
     */
    public static void verifyError() {
        if(Verify.errorBuffer.length() > 0) {  //第二步：在代码最后，通过errorBuffer抛出断言失败AssertionError异常(错误)
            throw new AssertionError(Verify.errorBuffer.toString());
        }
    }
}
