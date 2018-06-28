package com.youe.cd.test.dao;

import com.youe.cd.test.util.config.Config;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.Map;

public class MysqlDao {
    //Map<String, String> dbConnMap = getDBConnMap();

    /*public static Map<String, String> getDBConnMap() {
        Map<String, String> dbConnMap = new HashMap<String, String>(); //重要：使用这种方式初初化

        dbConnMap.put("dbDriver", Config.DB_DRIVER);
        dbConnMap.put("dbUrl", Config.DB_URL);
        dbConnMap.put("dbUserName", Config.DB_USERNAME);
        dbConnMap.put("dbPassword", Config.DB_PASSWORD);

        return dbConnMap;
    }*/


    //@Test
    public static void GetConnection(Map<String, String> dbConnMap) {
        try {
            Class.forName(dbConnMap.get("dbDriver"));  //注册jdbc驱动
            System.out.println("成功加载mysql驱动");
        } catch (ClassNotFoundException e) {
            System.out.println("找不到mysql驱动");
            e.printStackTrace();
        }

        String url = dbConnMap.get("dbUrl");
        Connection conn;

        try {
            conn = DriverManager.getConnection(url, dbConnMap.get("dbUserName"), dbConnMap.get("dbPassword"));
            Statement stmt = conn.createStatement();  //创建statement对象
            System.out.println("成功连接到数据库");
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //@Test
    public static ResultSet queryTable(Map<String, String> dbConnMap, String sql) {
        ResultSet rs = null;

        try {
            Class.forName(dbConnMap.get("dbDriver"));  //注册jdbc驱动
            System.out.println("成功加载mysql驱动");

            String url = dbConnMap.get("dbUrl");
            Connection conn;

            conn = DriverManager.getConnection(url, dbConnMap.get("dbUserName"), dbConnMap.get("dbPassword"));
            Statement stmt = conn.createStatement();  //创建statement对象
            System.out.println("成功连接到数据库");

            //String sql = "select id,classify,create_time from t_classify where id = 56";
            rs = stmt.executeQuery(sql);

            System.out.println("id" + "\t" + "classify" + "\t" + "create_time");
            while(rs.next()) {
                System.out.print(rs.getInt("id") + "\t");
                System.out.print(String.format("%-8s\t", rs.getString("classify"))); //-表示左对齐，8表示占8个字符
                System.out.println(rs.getDate("create_time") + "\t");
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rs;
    }

    public static void updateTable(Map<String, String> dbConnMap, String sql) {
        //ResultSet rs = null;

        try {
            Class.forName(dbConnMap.get("dbDriver"));  //注册jdbc驱动
            System.out.println("成功加载mysql驱动");

            String url = dbConnMap.get("dbUrl");
            Connection conn;

            conn = DriverManager.getConnection(url, dbConnMap.get("dbUserName"), dbConnMap.get("dbPassword"));
            Statement stmt = conn.createStatement();  //创建statement对象
            System.out.println("成功连接到数据库");

            //String sql = "select id,classify,create_time from t_classify where id = 56";
            stmt.executeUpdate(sql);

            /*System.out.println("id" + "\t" + "classify" + "\t" + "create_time");
            while(rs.next()) {
                System.out.print(rs.getInt("id") + "\t");
                System.out.print(String.format("%-8s\t", rs.getString("classify"))); //-表示左齐，8表示占8个字符
                System.out.println(rs.getDate("create_time") + "\t");
            }

            rs.close();*/
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //return rs;
    }

    public static void executeInsertTable(Map<String, String> dbConnMap, String tableName, String colName1, String colName2, String colName3, String colName4, String colValue1, String colValue2, String colValue3, String colValue4) {
        //ResultSet rs = null;

        try {
            Class.forName(dbConnMap.get("dbDriver"));  //注册jdbc驱动
            System.out.println("成功加载mysql驱动");

            String url = dbConnMap.get("dbUrl");
            Connection conn;

            conn = DriverManager.getConnection(url, dbConnMap.get("dbUserName"), dbConnMap.get("dbPassword"));
            Statement stmt = conn.createStatement();  //创建statement对象
            System.out.println("成功连接到数据库");

            //String sql = "select id,classify,create_time from t_classify where id = 56";
            //String sql = "insert into alitable(search_key, domain, domain_status, update_time) values(62, '科技', '2017-11-30')";
            //特别注意：sql语句中更新数据库的数据要加单引号
            String sql = "insert into " + tableName + "(" + colName1 + ", " + colName2 + ", " + colName3 + ", " + colName4+ ") values('" + colValue1 + "', '" + colValue2 + "', '" + colValue3 + "', '" + colValue4 + "')";
            stmt.executeUpdate(sql);


            /*System.out.println("id" + "\t" + "classify" + "\t" + "create_time");
            while(rs.next()) {
                System.out.print(rs.getInt("id") + "\t");
                System.out.print(String.format("%-8s\t", rs.getString("classify"))); //-表示左齐，8表示占8个字符
                System.out.println(rs.getDate("create_time") + "\t");
            }

            rs.close();*/
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //return rs;
    }

    public static boolean isContains(Map<String, String> dbConnMap, String tableName, String checkColName, String searchKey) {
        ResultSet rs = null;
        boolean flag = false;

        try {
            Class.forName(dbConnMap.get("dbDriver"));  //注册jdbc驱动
            System.out.println("成功加载mysql驱动");

            String url = dbConnMap.get("dbUrl");
            Connection conn;

            conn = DriverManager.getConnection(url, dbConnMap.get("dbUserName"), dbConnMap.get("dbPassword"));
            Statement stmt = conn.createStatement();  //创建statement对象
            System.out.println("成功连接到数据库");

            //String sql = "select id,classify,create_time from t_classify where id = 56";
            String sql = "select * from " + tableName;
            rs = stmt.executeQuery(sql);

            //System.out.println("id" + "\t" + "classify" + "\t" + "create_time");
            while(rs.next()) {
                /*System.out.print(rs.getInt("id") + "\t");
                System.out.print(String.format("%-8s\t", rs.getString("classify"))); //-表示左对齐，8表示占8个字符
                System.out.println(rs.getDate("create_time") + "\t");*/
                if(rs.getString(checkColName).equals(searchKey)) {
                    flag = true;
                    break;
                }
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }

    @Test
    public void runTest() {
        String sql = "select id,classify,create_time from t_classify";
        String sql2 = "update t_classify set classify = '教育大数据ch2' where id = 56";
        String sql3 = "insert into t_classify(id, classify, create_time) values(62, '科技', '2017-11-30')";
        String sql4 = "delete from t_classify where id = 62";

        //DateUtil.getDate();

        GetConnection(Config.dbConnMap);
        //2updateTable(Config.dbConnMap, sql2);
        //updateTable(Config.dbConnMap, sql3);
        //updateTable(Config.dbConnMap, sql4);
        //2queryTable(Config.dbConnMap, sql);
    }



}
