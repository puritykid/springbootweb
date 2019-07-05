package com.example.demo.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * 
 * 
 * @Title:CommonUtil
 * @Package com.lunz.uc.users.util
 * @Description: 公共工具类
 * @author chenxiaojun
 * @date 2019/04/24
 */
public class CommonUtil {

	/**
	 * 分割-逗号
	 */
	public static final String COMMON_SPLIT = ",";

	/**
	 * 判断对象是否为null和空
	 * 
	 * @param value
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isObjectNull(Object object) {
		if (object == null) {
			return true;
		} else if (object instanceof java.util.Collection) {
			return ((java.util.Collection) object).isEmpty() ? true : false;
		} else if (object instanceof java.util.Map) {
			return ((java.util.Map) object).isEmpty() ? true : false;
		} else if (object instanceof java.lang.String) {
			return ((java.lang.String) object).trim().length() == 0 ? true : false;
		}
		return false;
	}
	
	/**
	 * 判断对象是否为null字符串和空
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isNullStr(String str) {
		return str.toLowerCase().trim().equals("null");
	}
	
	
	public static List<String> splitStr(String str, String separator) {
		List<String> list = new ArrayList<String>();
		if (CommonUtil.isObjectNull(str)) {
			return null;
		}
		String[] split = str.split(separator);
		list.addAll(Arrays.asList(split));
		return list;
	}

	/**
	 * 生成UUID
	 * @Description: TODO
	 */
	public static String getUUID() {
		
		return UUID.randomUUID().toString();
	}	

	public static String getDate(Date date,String dateFormate) {
		
		SimpleDateFormat fmtDateFormat = new SimpleDateFormat(dateFormate);
		return fmtDateFormat.format(date);
	}
}


