package org.smart4j.framework.proxy;

/**
 * 代理接口
 * Created by AdrainHuang on 2017/2/2.
 */
public interface Proxy {

	/**
	 * 执行链式代理(即将多个代理通过一个链子串起来，一个个地去执行，执行顺序取决于链上的先后顺序)
	 */
	Object doProxy(ProxyChain proxyChain) throws Throwable;
}
