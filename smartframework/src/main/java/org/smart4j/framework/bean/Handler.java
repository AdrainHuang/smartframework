package org.smart4j.framework.bean;

import java.lang.reflect.Method;

/**
 * 封装 Actoin 信息
 * Created by AdrainHuang on 2017/1/30.
 */
public class Handler {

	/**
	 * Controller 类
	 */
	private Class<?> controllerClass;

	/**
	 * Action 方法
	 */
	private Method acctionMethod;

	public Handler(Class<?> controllerClass, Method acctionMethod) {
		this.controllerClass = controllerClass;
		this.acctionMethod = acctionMethod;
	}

	public Class<?> getControllerClass() {
		return controllerClass;
	}

	public Method getAcctionMethod() {
		return acctionMethod;
	}
}
