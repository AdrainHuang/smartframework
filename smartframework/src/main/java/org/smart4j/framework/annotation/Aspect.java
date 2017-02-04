package org.smart4j.framework.annotation;

import java.lang.annotation.*;

/**
 * 切面注解
 * Created by AdrainHuang on 2017/2/2.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {
	/**
	 * 注解
	 */
	Class<? extends Annotation> value();
}
