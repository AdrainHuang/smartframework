package org.smart4j.framework.bean;


import org.apache.commons.collections.map.HashedMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by AdrainHuang on 2017/1/30.
 */
public class View {

	/**
	 * 视图路径
	 */
	private String path;

	/**
	 * 模型数据
	 */
	private Map<String , Object> model;

	public View(String path) {
		this.path = path;
		model = new HashMap<String,Object>();
	}

	public View addModel(String key, Object value){
		model.put(key, value);
		return this;
	}

	public String getPath(){
		return path;
	}

	public Map<String, Object> getModel() {
		return model;
	}
}
