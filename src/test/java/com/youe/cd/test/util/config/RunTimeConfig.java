package com.youe.cd.test.util.config;

import com.youe.cd.test.util.DateUtil;

import java.util.HashMap;
import java.util.Map;

public class RunTimeConfig {
    //运行时参数配置
    public static String nowTimeStr = DateUtil.getDateLiteEssential();
    public static String nowTimeEssential = DateUtil.getDateLiteEssential();

    public static String dataSourceNameMysql = "源M" + nowTimeStr;
    public static String dataSourceNameFtp = "源F" + nowTimeStr;

    public static String dataSetNameM2M = "MM集_" + nowTimeEssential;
    public static String taskNameM2M = "MM" + nowTimeEssential;
    public static String dataSetNameF2M = "FM集_" + nowTimeEssential;
    public static String taskNameF2M = "FM" + nowTimeEssential;

    public RunTimeConfig() {
    }

    public static String getDataSourceNameMysql() {
        return dataSourceNameMysql;
    }

    public static void setDataSourceNameMysql(String dataSourceNameMysql) {
        RunTimeConfig.dataSourceNameMysql = dataSourceNameMysql;
    }

    public static String getDataSetNameM2M() {
        return dataSetNameM2M;
    }

    public static void setDataSetNameM2M(String dataSetNameM2M) {
        RunTimeConfig.dataSetNameM2M = dataSetNameM2M;
    }

    public static String getTaskNameM2M() {
        return taskNameM2M;
    }

    public static void setTaskNameM2M(String taskNameM2M) {
        RunTimeConfig.taskNameM2M = taskNameM2M;
    }


    public static String getDataSourceNameFtp() {
        return dataSourceNameFtp;
    }

    public static void setDataSourceNameFtp(String dataSourceNameFtp) {
        RunTimeConfig.dataSourceNameFtp = dataSourceNameFtp;
    }

    public static String getDataSetNameF2M() {
        return dataSetNameF2M;
    }

    public static void setDataSetNameF2M(String dataSetNameF2M) {
        RunTimeConfig.dataSetNameF2M = dataSetNameF2M;
    }

    public static String getTaskNameF2M() {
        return taskNameF2M;
    }

    public static void setTaskNameF2M(String taskNameF2M) {
        RunTimeConfig.taskNameF2M = taskNameF2M;
    }
}
