package com.youe.cd.test.service.modela;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.youe.cd.test.controller.TestBase.driver;

public class ParamSearchWebService {
	public static void paramSearchWeb(String searchKey) throws Exception {
	    driver.findElement(By.id("kw")).click();
	    driver.findElement(By.id("kw")).clear();
	    driver.findElement(By.id("kw")).sendKeys(searchKey);
	    driver.findElement(By.id("su")).click();
	    Thread.sleep(5000);
	}
}
