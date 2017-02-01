package aop.demo;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

/**
 * 环绕增强
 * Created by AdrainHuang on 2017/2/2.
 */
@Component
public class GreetingAroundAdvice implements MethodInterceptor{

	public Object invoke(MethodInvocation invocation) throws Throwable {
		before();
		Object result = invocation.proceed();
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
