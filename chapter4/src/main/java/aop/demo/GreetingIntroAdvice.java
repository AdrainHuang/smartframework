package aop.demo;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;
import org.springframework.stereotype.Component;

/**
 * Created by AdrainHuang on 2017/2/2.
 */
@Component
public class GreetingIntroAdvice extends DelegatingIntroductionInterceptor implements Apology{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		return super.invoke(invocation);
	}

	public void saySorry(String name) {
		System.out.println("Sorry!" + name);
	}
}
