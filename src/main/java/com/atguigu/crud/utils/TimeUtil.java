package com.atguigu.crud.utils;
/*
 * 时间相关的工具类
 */

import static org.hamcrest.CoreMatchers.nullValue;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
	static Date day =null;
	/*
	 * string---->date		"yyyy-MM-dd HH:mm:ss"
	 */
	public static Date stringToDate(String date,String model) {
		try {
		DateFormat dateFormat = new SimpleDateFormat(model);
		day = dateFormat.parse(date);
		System.out.println(day.getMonth()+"月份");
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			System.err.println("+++++TimeUtil+++stringToDate出错！！！");
		}
		return day;
	}
	
	/*
	 *date ---->string		"yyyy-MM-dd HH:mm:ss"
	 */
	public static String dateToString(Date date,String model) {
		DateFormat dateFormat = new SimpleDateFormat(model);
		return dateFormat.format(date);
	
	}
	
	
	/**
	 * 比较日期      大于，返回1		0	-1
	 * @param DATE1
	 * @param DATE2
	 * @return
	 */
	 public static int compare_date(String DATE1, String DATE2) {
	        
	        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        try {
	            Date dt1 = df.parse(DATE1);
	            Date dt2 = df.parse(DATE2);
	            if (dt1.getTime() > dt2.getTime()) {
	                //System.out.println("dt1 在dt2前");
	                return 1;
	            } else if (dt1.getTime() < dt2.getTime()) {
	                //System.out.println("dt1在dt2后");
	                return -1;
	            } else {
	                return 0;
	            }
	        } catch (Exception exception) {
	            exception.printStackTrace();
	        }
	        return 0;
	    }
}
