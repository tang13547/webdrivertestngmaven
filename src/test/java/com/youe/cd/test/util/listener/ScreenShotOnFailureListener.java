package com.youe.cd.test.util.listener;

import com.youe.cd.test.util.config.Config;
import com.youe.cd.test.util.ScreenShotUtil;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class ScreenShotOnFailureListener extends TestListenerAdapter {
    public static WebDriver driver;
    public static String className;
    public static String methodName;

    @Override
    public void onTestFailure(ITestResult tr) {
        super.onTestFailure(tr);

        //ScreenShotUtil.takeScreenShot(driver, Config.screenShotPath);
        ScreenShotUtil.takeScreenShot(driver, className, methodName, Config.screenShotPath);
    }

}
