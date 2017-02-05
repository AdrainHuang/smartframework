package org.smart4j.framework.util;

import org.apache.commons.lang.StringUtils;

/**
 * Created by AdrainHuang on 2017/1/28.
 * 字符串工具类
 */
public class StringUtil {

	/**
	 * 字符分隔符
	 */
	public static final String SEPARATOR = String.valueOf((char)29);
    /**
     * 判断字符串是否为空
     */
    public static boolean isEmpty(String str){
        if(str != null){
            str = str.trim();
        }
        return StringUtils.isEmpty(str);
    }

    /**
     * 判断字符串是否非空
     */
    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }

	public static String[] splitString(String s, String pattern) {
    	return StringUtils.split(s,pattern);
	}
}
