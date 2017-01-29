package org.smart4j.chapter2.util;

import org.apache.commons.lang.StringUtils;

/**
 * Created by AdrainHuang on 2017/1/28.
 */
public class CastUtil {
    /**
     * 转为String 型
     */
    public static String castString(Object obj){
        return CastUtil.castString(obj,"");
    }

    /**
     * 转为String 型(提供默认值)
     */
    private static String castString(Object obj, String defaultValue) {
        return obj != null ? String.valueOf(obj) : defaultValue;
    }

    /**
     * 转为 double型
     */
    public static double castDouble(Object obj){
        return CastUtil.castDouble(obj, 0);
    }

    /**
     * 转为 double型(提供默认值)
     */
    private static double castDouble(Object obj, double defaultValue) {
        double doubleValue = defaultValue;
        if(obj != null){
            String strValue = castString(obj);
            if(StringUtils.isNotEmpty(strValue)){
                try {
                    doubleValue = Double.parseDouble(strValue);
                } catch ( NumberFormatException e){
                    doubleValue = defaultValue;
                }
            }
        }
        return doubleValue;
    }

    /**
     * 转成long型
     */
    public static long castLong(Object obj){
        return CastUtil.castLong(obj,0);
    }

    /**
     * 转成long型(提供默认值)
     */
    private static long castLong(Object obj, long defaultValue) {
        long longValue = defaultValue;
        if(obj != null){
            String strValue = castString(obj);
            if(StringUtils.isNotEmpty(strValue)){
                try {
                    longValue = Long.parseLong(strValue);
                } catch ( NumberFormatException e){
                    longValue = defaultValue;
                }
            }
        }
        return longValue;
    }

    /**
     * 转换成int
     */
    public static int castInt(Object obj){
        return  CastUtil.castInt(obj, 0);
    }

    /**
     * 转换成int（提供默认值）
     */
    private static int castInt(Object obj, int defaultValue) {
        int intValue = defaultValue;
        if(obj != null){
            String strValue = castString(obj);
            if(StringUtils.isNotEmpty(strValue)){
                try {
                    intValue = Integer.parseInt(strValue);
                } catch ( NumberFormatException e){
                    intValue = defaultValue;
                }
            }
        }
        return intValue;
    }

    /**
     * 转换成boolean型
     */
    public static boolean castBoolean(Object obj){
        return CastUtil.castBoolean(obj, false);
    }

    private static boolean castBoolean(Object obj, boolean defaultValue) {
        boolean booleanValue = defaultValue;
        if(obj != null){
          booleanValue = Boolean.parseBoolean(castString(obj));
        }
        return booleanValue;
    }
}
