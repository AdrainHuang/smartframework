package aop.demo;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 动态代理技术
 * Created by AdrainHuang on 2017/2/2.
 */
public class CGLibDynamicProxy implements MethodInterceptor {

	private static CGLibDynamicProxy instance = new CGLibDynamicProxy();

	private CGLibDynamicProxy() {
	}

	public <T> T getProxy(Class<T> cls){
		return (T) Enhancer.create(cls,this);
	}

	public static CGLibDynamicProxy getInstance() {
		return instance;
	}

	public Object intercept(Object target, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		before();
		Object result = proxy.invokeSuper(target, args);
		after();
		return result;
	}

	private void after() {
		System.out.println("After");
	}

	private void before() {
		System.out.println("Before");
	}
}
