package com.inga.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateCommon {

	/*
	 * @return yyyy-MM-dd
	 * 
	 * @author InGa
	 */
	public static String getNowDateDB(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(new Date());
		return date;
	}
	
	/*
	 * @return yyyy_MM_dd
	 * 
	 * @author InGa
	 */
	public static String getNowDateyyyy_MM_dd(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd");
		String date = sdf.format(new Date());
		return date;
	}
}
