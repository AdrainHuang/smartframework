package org.smart4j.framework.helper;

import org.smart4j.framework.util.ArrayUtil;
import org.smart4j.framework.util.CollectionUtil;
import org.smart4j.framework.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * 依赖注入助手类
 * Created by AdrainHuang on 2017/1/30.
 */
public final class IocHelper {

	static {
		//获取所有的 Bean 类与 Bean 实例之间的映射关系（简称 Bean Map)
		Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
		if (CollectionUtil.isNotEmpty(beanMap)){
			//遍历 Bean Map
			for (Map.Entry<Class<?>, Object> beanEntry : beanMap.entrySet()){
				//从BeanMap中获取 Bean 类与 Bean 实例
				Class<?> beanClass = beanEntry.getKey();
				Object beanInstance = beanEntry.getValue();
				//获取  Bean 类定义 的所有成员变量（简称Bean Field)
				Field[] beanFields = beanClass.getDeclaredFields();
				if (ArrayUtil.isNotEmpty(beanFields)){
					//遍历 Bean Field
					for (Field beanField : beanFields){
						//判断当前 Bean Field 是否带有 Inject 注解
						Class<?> beanFieldClass = beanField.getType();
						Object beanFieldInstance = beanMap.get(beanFieldClass);
						if (beanFieldInstance != null){
							//通过反射初始化 BeanField 的值
							ReflectionUtil.setField(beanInstance, beanField, beanFieldInstance);
						}
					}
				}
			}
		}
	}
}
