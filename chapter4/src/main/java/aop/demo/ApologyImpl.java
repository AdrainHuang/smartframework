package aop.demo;

/**
 * Created by AdrainHuang on 2017/2/2.
 */
public class ApologyImpl implements Apology{
	public void saySorry(String name) {
		System.out.println("Sorry ! " + name);
	}
}
