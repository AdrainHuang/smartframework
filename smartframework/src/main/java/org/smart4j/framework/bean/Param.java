package org.smart4j.framework.bean;

import org.smart4j.framework.util.CastUtil;
import org.smart4j.framework.util.ClassUtil;

import java.util.Map;

/**
 * 请求参数对象
 * Created by AdrainHuang on 2017/1/30.
 */
public class Param {

	private Map<String , Object> paramMap;

	public Param(Map<String, Object> paramMap) {
		this.paramMap = paramMap;
	}

	/**
	 * 根据参数名获取 long 型参数值
	 */
	public long getLong(String name){
		return CastUtil.castLong(paramMap.get(name));
	}

	public Map<String, Object> getParamMap() {
		return paramMap;
	}
}
