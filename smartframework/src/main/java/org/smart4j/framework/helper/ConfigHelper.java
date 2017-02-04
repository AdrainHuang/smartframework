package org.smart4j.framework.helper;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.smart4j.framework.ConfigConstant;
import org.smart4j.framework.util.PropsUtil;

import java.util.Properties;

/**
 * Created by AdrainHuang on 2017/1/29.
 */
public class ConfigHelper {

	private static final Properties CONFIG_PROPS = PropsUtil.loadProps(ConfigConstant.CONFIG_FILE);

	/**
	 * 获取JDBC驱动
	 */
	public static String getJdbcDriver(){
		return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_DRIVE);
	}

	/**
	 * 获取 JDBC URL
	 */
	public static String getJdbcUrl(){
		return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_URL);
	}

	/**
	 * 获取 JDBC用户
	 */
	public static String getJdbcUsername(){
		return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_USERNAME);
	}

	/**
	 * 获取JDBC密码
	 */
	public static String getJDbcPassword(){
		return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_PASSWORD);
	}

	/**
	 * 获取应用基础包名
	 */
	public static String getAppBasePackage(){
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_BASE_PACKAGE);
	}

	/**
	 * 获取应用 JSP 路径
	 */
	public static String getAppJspPath(){
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_JSP_PATH);
	}

	/**
	 * 获取应用表态资源路径
	 */
	public static String getAppAssetPath(){
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_ASSET_PATH);
	}
}
