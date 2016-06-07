/*
 * Copyright 2015 the original author or phly.
 * 未经正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
package com.phly.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期帮助类
 * 
 * @Description TODO
 * @author linyong
 * @since 2015年6月13日 下午2:11:24
 */
public class DateUtil {
	
	private static final String DEFAULT_PATTERN = "yyyy-MM-dd";
	
	/**
	 * 格式化日期
	 * @param pattern 格式化
	 * @param date 日期
	 * @return
	 */
	public static String pattern(String pattern, Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
	
	/**
	 * 获取给定时间的前一天
	 * @param date
	 * @return
	 */
	public static String getDayBefore(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH,cal.get(Calendar.DAY_OF_MONTH) -  1);
		return pattern(DEFAULT_PATTERN,cal.getTime());
	}
	
	
}
