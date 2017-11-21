package uestc.utils;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;

public class DateTimeUtil {
    public static Date strToDate(String dateTimeStr,String formaStr){
        DateTimeFormatter dateTimeFormatter= DateTimeFormat.forPattern(formaStr);
        DateTime dateTime=dateTimeFormatter.parseDateTime(dateTimeStr);
        return dateTime.toDate();
    }
    public static String dateToStr(Date date,String formatStr){
        if(date==null)
            return StringUtils.EMPTY;
        DateTime dateTime=new DateTime(date);
        return dateTime.toString(formatStr);
    }
    public static Date strToDate(String dateTimeStr){
        DateTimeFormatter dateTimeFormatter= DateTimeFormat.forPattern("yyyy-MM-dd HH");
        DateTime dateTime=dateTimeFormatter.parseDateTime(dateTimeStr);
        return dateTime.toDate();
    }
    public static String dateToStr(Date date){
        if(date==null)
            return StringUtils.EMPTY;
        DateTime dateTime=new DateTime(date);
        return dateTime.toString("yyyy-MM-dd HH");
    }

//    public static void main(String[] args) {
//        System.out.println(DateTimeUtil.dateToStr(new Date(),"yyyy-MM-dd HH"));
//        System.out.println(DateTimeUtil.strToDate("2010-01-01 11","yyyy-MM-dd HH"));
//    }

}
