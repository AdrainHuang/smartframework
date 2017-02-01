package aop.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * Created by AdrainHuang on 2017/2/2.
 */
@Aspect
@Component
public class GreetingAspect {

	@DeclareParents(value = "aop.demo.GreetingImpl", defaultImpl = ApologyImpl.class)
	private Apology apology;

//	@Around("execution(* aop.demo.GreetingImpl.*(..))")
	@Around("@annotation(aop.demo.annotation.Tag)")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		before();
		Object result = pjp.proceed();
		after();
		return result;
	}
	private void after() {
		System.out.println("After AspectJ");
	}

	private void before() {
		System.out.println("Before AspectJ");
	}
}
