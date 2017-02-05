package org.smart4j.framework.bean;

import org.smart4j.framework.util.CastUtil;
import org.smart4j.framework.util.CollectionUtil;
import org.smart4j.framework.util.StringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 请求参数对象
 * Created by AdrainHuang on 2017/1/30.
 */
public class Param {

	private List<FormParam> formParamList;

	private List<FileParam> fileParamList;

	public Param(List<FormParam> formParamList) {
		this.formParamList = formParamList;
	}

	public Param(List<FormParam> formParamList, List<FileParam> fileParamList) {
		this.formParamList = formParamList;
		this.fileParamList = fileParamList;
	}

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

	/**
	 * 验证参数是否为空
	 */
	public boolean isEmpty() {
		return CollectionUtil.isEmpty(paramMap);
	}

	/**
	 * 请求参数映射
	 */
	public Map<String, Object> getFieldMap(){
		Map<String, Object> fieldMap = new HashMap<String , Object>();
		if (CollectionUtil.isNotEmpty(formParamList)){
			for (FormParam formParam : formParamList){
				String fieldName = formParam.getFieldName();
				Object fieldValue = formParam.getFieldValue();
				if (fieldMap.containsKey(fieldName)){
					fieldValue = fieldMap.get(fieldName) + StringUtil.SEPARATOR + fieldValue;
				}
				fieldMap.put(fieldName, fieldValue);
			}
		}
		return fieldMap;
	}

	/**
	 * 获取上传文件映射
	 */
	public Map<String, List<FileParam>> getFileMap(){
		Map<String, List<FileParam>> fileMap = new HashMap<String , List<FileParam>>();
		if (CollectionUtil.isNotEmpty(fileParamList)){
			for (FileParam fileParam : fileParamList){
				String filedName = fileParam.getFiledName();
				List<FileParam> fileParamList;
				if (fileMap.containsKey(filedName)){
					fileParamList = fileMap.get(filedName);
				} else {
					fileParamList = new ArrayList<FileParam>();
				}
				fileParamList.add(fileParam);
				fileMap.put(filedName, fileParamList);
			}
		}
		return fileMap;
	}

	/**
	 * 获取所有上传文件
	 */
	public List<FileParam> getFileList(String fieldName){
		return (List<FileParam>) getFieldMap().get(fieldName);
	}

	/**
	 * 获取唯一上传文件
	 */
	public FileParam getFile(String fieldName){
		List<FileParam> fileParamList = getFileList(fieldName);
		if (CollectionUtil.isNotEmpty(fileParamList) && fileParamList.size() == 1){
			return fileParamList.get(0);
		}
		return null;
	}

	/**
	 * 验证参数是否为空
	 */
//	public boolean isEmpty(){
//		return CollectionUtil.isEmpty(formParamList) && CollectionUtil.isNotEmpty(fileParamList);
//	}
}
