package com.youe.cd.test.util;

import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

//import static com.youe.cd.test.dao.MysqlDao.getDBConnMap;

public class Config {

	public static final String chromedriverPath = "./src/test/resources/driver/chromedriver.exe";
	public static final String firefoxdriverPath = "./src/test/resources/driver/geckodriver.exe";
	public static final String iedriverPath = "./src/test/resources/driver/IEDriverServer.exe";
	
	public static final String baseUrl = "http://192.168.30.231:8000/#/";
	public static final String baseUrl2 = "http://192.168.30.231:8000/#/login"; //临时测试使用
	public static final String txtFilePath = "./src/test/resources/data/data.txt"; //前面必须加。 表示路径从工程开始
	public static final String csvFilePath = "./src/test/resources/data/csvdata.csv";
	public static final String excelFilePath = "./src/test/resources/data/exceldata.xls";
	public static final String errorHintStr = "验证码输入有误"; //输入错误验证后的提示
	
	//Tesseract-OCR处理生成图片路径及转换成txt结果路径配置
	public static final String picFilePath = "D:\\Tesseract-OCR\\train\\test.png";
	public static final String picFileDirAfterClean = "D:\\Tesseract-OCR\\train\\cleanpic"; //处理图片后的目录（注意是目录）
	public static final String txtResultFilePath = "D:\\Tesseract-OCR\\train\\result"; //特别注意：没有加.txt文件后缀

	//配置截图目录
	public static final String screenShotPath = "E:\\screenshot\\testProject"; //截图目录（注意是目录）

	//配置数据库连接信息
	public static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	public static final String DB_SERVER_URL = "172.16.0.241:3306";
	public static final String DB_NAME = "test";
	public static final String DB_URL = "jdbc:mysql://" + DB_SERVER_URL + "/" + DB_NAME + "?characterEncoding=utf-8&useSSL=false";
	public static final String DB_USERNAME = "root";
	public static final String DB_PASSWORD = "1qaz@WSX";

	//public static final Map<String, String> dbConnMap = getDBConnMap();
	public static final Map<String, String> dbConnMap;
	static {
		dbConnMap = new HashMap<String, String>();
		dbConnMap.put("dbDriver", Config.DB_DRIVER);
		dbConnMap.put("dbUrl", Config.DB_URL);
		dbConnMap.put("dbUserName", Config.DB_USERNAME);
		dbConnMap.put("dbPassword", Config.DB_PASSWORD);
	}

	//使用cookie登录配置
	/*public static final String cookieName = "BAIDUID";
	public static final String cookieValue = "56A7F56A88C2384696566954F4C441E7:FG=1";
	public static final String cookieName2 = "BDUSS";
	public static final String cookieValue2 = "2h4Ty02aFBvNTZ0Q0pCbUkwS1c3MUdyV25SQnVkWG9rVnVwTnFIa1lPeTQ4dTlaSUFBQUFBJCQAAAAAAAAAAAEAAAAZnv4vY2VyYWludGFuZzEyMwAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAALhlyFm4ZchZU";
	*/
	
}
