package org.nyer.orm.util;

import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;

public class DateUtils {
	public static final String dbTimeFormat = "yyyy-MM-dd HH:mm:ss";
	public static String getFormatedCurrentTime(String pattern){
		return DateFormatUtils.format(System.currentTimeMillis(), pattern);
	}
	
	public static String getDBCurrentTime(){
		return DateFormatUtils.format(System.currentTimeMillis(), dbTimeFormat);
	}
	
	public static String getDBFormatTime(Date date){
		return DateFormatUtils.format(date, dbTimeFormat);
	}
}
