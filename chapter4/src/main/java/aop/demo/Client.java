package aop.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by AdrainHuang on 2017/2/2.
 */
public class Client {
	public static void main(String[] args) {
//		Greeting greeting = CGLibDynamicProxy.getInstance().getProxy(GreetingImpl.class);
//		greeting.sayHi("Jack");
		ApplicationContext context = new ClassPathXmlApplicationContext("aop/demo/spring.xml");
//		转型为hhsfod，而并非它的 Greeting接口
		GreetingImpl greetingImpl = (GreetingImpl) context.getBean("greetingProxy");
		greetingImpl.sayHi("Jack");
//		将目标类型向上转型为Apology接口（这是引入增强给我们带来的特性，也就是接口动态实现功能
		Apology apology = (Apology) greetingImpl;
		apology.saySorry("Jack");

		Greeting greeting = (Greeting) context.getBean("greetingImpl");
		greeting.sayHi("Tom");
		Apology apology1 = (Apology) greeting;
		apology1.saySorry("Tom");
	}
}
