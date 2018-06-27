package com.youe.cd.test.service.modela;

//import static org.junit.Assert.assertEquals;
import com.youe.cd.test.util.action.ElementAction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.youe.cd.test.controller.TestBase.driver;

public class SearchWebService {
	public static void searchWeb() throws Exception {
	    driver.findElement(By.id("kw")).click();
	    driver.findElement(By.id("kw")).clear();
	    driver.findElement(By.id("kw")).sendKeys("pplive");
	    driver.findElement(By.id("su")).click();
	    Thread.sleep(5000);
	    
	    String homehandle = driver.getWindowHandle();
	    System.out.println("homehandle is " + homehandle);
	    
	    driver.findElement(By.linkText("pplive_百度百科")).click();
	    Thread.sleep(12000); 
	   	    	    
	    ElementAction.switchToLastWindow();
	    
	    //Thread.sleep(5000);
	    //Assert.assertEquals(driver.getTitle(), "聚力视频_百度百科");
	    //driver.close();  //使用driver.close()之后必须使用driver.switchTo().window(homehandle)回到原窗口，否则后面的方法再使用driver时会报NoSuchWindow错误
	    //driver.switchTo().window(homehandle); //切换到原窗口,非常重要
	    
	    //return driver;
	}

}

