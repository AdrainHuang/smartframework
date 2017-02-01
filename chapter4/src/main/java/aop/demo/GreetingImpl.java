package aop.demo;

import aop.demo.annotation.Tag;
import org.springframework.stereotype.Component;

/**
 * Created by AdrainHuang on 2017/2/2.
 */

@Component
public class GreetingImpl implements Greeting{

	@Tag
	public void sayHi(String name) {
		System.out.println("say 声hi to " + name);
	}

	public void goodMorning(String name){
		System.out.println("Good Morning ! " + name);
	}

	public void gooNight(String name){
		System.out.println("Good Night ! " + name);
	}
}
