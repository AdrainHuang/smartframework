package org.smart4j.framework.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * 封装请求信息
 * Created by AdrainHuang on 2017/1/30.
 */
public class Request {

	/**
	 * 请求方法
	 */
	private String requsetMethod;

	/**
	 * 请求路径
	 */
	private String requestPath;

	public Request(String requsetMethod, String requestPath) {
		this.requsetMethod = requsetMethod;
		this.requestPath = requestPath;
	}

	public String getRequsetMethod() {
		return requsetMethod;
	}

	public String getRequestPath() {
		return requestPath;
	}

	@Override
	public boolean equals(Object o) {
		return EqualsBuilder.reflectionEquals(this,o);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
}
