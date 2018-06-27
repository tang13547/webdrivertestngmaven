package com.youe.cd.test.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static String getDate() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //System.out.println("Current date is: " + sdf.format(date));

        return sdf.format(date);
    }

    public static String getDateLite() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
        //System.out.println("Current date is: " + sdf.format(date));

        return sdf.format(date);
    }

    public static String getDateLiteOnlyDay() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //System.out.println("Current date is: " + sdf.format(date));

        return sdf.format(date);
    }

    public static String getDateLiteEssential() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("ddHHmmss");
        //System.out.println("Current date is: " + sdf.format(date));

        return sdf.format(date);
    }

    public static String getAfterDate(long afterTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        Date afterDate = new Date(now.getTime() + afterTime);

        return sdf.format(afterDate);
    }

    public static String getAfterDateOnlySecondHalf(long afterTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date now = new Date();
        Date afterDate = new Date(now.getTime() + afterTime);

        return sdf.format(afterDate);
    }

}
