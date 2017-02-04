package org.smart4j.framework;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.smart4j.framework.helper.AopHelper;
import org.smart4j.framework.helper.ClassHelper;
import org.smart4j.framework.helper.ControllerHelper;
import org.smart4j.framework.helper.IocHelper;
import org.smart4j.framework.util.ClassUtil;

/**
 * 加载相应的Helper 类
 * Created by AdrainHuang on 2017/1/30.
 */
public final class HelperLoader {

	public static void init() {
		Class<?>[] classList = {
				ClassHelper.class,
				BeanHandler.class,
				AopHelper.class,
				IocHelper.class,
				ControllerHelper.class
		};
		for (Class<?> cls : classList){
			ClassUtil.loadClass(cls.getName());
		}
	}
}
