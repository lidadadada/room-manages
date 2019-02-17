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
}
