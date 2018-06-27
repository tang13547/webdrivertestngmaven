package com.youe.cd.test.util;

import java.util.HashMap;
import java.util.Map;

public class RunTimeConfig {
    //测试使用的FMysql源信息
    public static final String MYSQL_JDBCURL = "192.168.30.237/test";
    public static final String MYSQL_USERNAME = "root";
    public static final String MYSQL_PASSWORD = "123456";
    public static final Map<String,String>  MysqlConnMap;
    static {
        MysqlConnMap = new HashMap<String,String>();
        MysqlConnMap.put("MYSQL_JDBCURL", MYSQL_JDBCURL);
        MysqlConnMap.put("MYSQL_USERNAME", MYSQL_USERNAME);
        MysqlConnMap.put("MYSQL_PASSWORD", MYSQL_PASSWORD);
    }

    //测试使用的FTP源信息
    public static final String FTP_URL = "192.168.30.232";
    public static final String FTP_PORT = "21";
    public static final String FTP_USERNAME = "ftpuser";
    public static final String FTP_PASSWORD = "ftpuser@123";
    public static final Map<String,String>  FTPConnMap;
    static {
        FTPConnMap = new HashMap<String,String>();
        FTPConnMap.put("FTP_URL", FTP_URL);
        FTPConnMap.put("FTP_PORT", FTP_PORT);
        FTPConnMap.put("FTP_USERNAME", FTP_USERNAME);
        FTPConnMap.put("FTP_PASSWORD", FTP_PASSWORD);
    }


}
