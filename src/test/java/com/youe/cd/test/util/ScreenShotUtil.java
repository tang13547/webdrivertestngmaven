package com.youe.cd.test.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class ScreenShotUtil {
    static Logger logger = LoggerFactory.getLogger(ScreenShotUtil.class);

    public static void takeScreenShot(WebDriver driver, String screenShotPath) {
        if(!(new File(screenShotPath).isDirectory())) {  //判断是否存在该目录
            new File(screenShotPath).mkdir(); //如果不存在则新建目录
        }

        String time = DateUtil.getDateLite();

        try {
            File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String objectivePath = screenShotPath + "\\" + time + ".png";
            FileUtils.copyFile(srcFile,new File(objectivePath));
            //System.out.println("测试失败，截图路径为：" + objectivePath);
            logger.error("[logger] 测试失败，截图路径为：" + objectivePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void takeScreenShot(WebDriver driver, String className, String screenShotPath) {
        if(!(new File(screenShotPath).isDirectory())) {  //判断是否存在该目录
            new File(screenShotPath).mkdir(); //如果不存在则新建目录
        }

        String time = DateUtil.getDateLite();

        try {
            File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String objectivePath = screenShotPath + "\\" + className+ "_" + time + ".png";
            FileUtils.copyFile(srcFile,new File(objectivePath));
            //System.out.println("测试失败，截图路径为：" + objectivePath);
            logger.error("[logger] 测试失败: " + className + "，截图路径为：" + objectivePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void takeScreenShot(WebDriver driver, String className, String methodName, String screenShotPath) {
        if(!(new File(screenShotPath).isDirectory())) {  //判断是否存在该目录
            new File(screenShotPath).mkdir(); //如果不存在则新建目录
        }

        String time = DateUtil.getDateLite();

        try {
            File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String objectivePath = screenShotPath + "\\" + className + "." + methodName + "_" + time + ".png";
            FileUtils.copyFile(srcFile,new File(objectivePath));
            //System.out.println("测试失败，截图路径为：" + objectivePath);
            logger.error("[logger] 测试失败: " + className + ": " + methodName + "，截图路径为：" + objectivePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
