package com.xwj.proxy.staproxy;

import com.xwj.proxy.RealSubject;
import com.xwj.proxy.Subject;

/**
 * 静态代理类Proxy
 * 
 * 优点：可以做到不对目标对象进行修改的前提下，对目标对象进行功能的扩展和拦截。
 * 缺点：因为代理对象，需要实现与目标对象一样的接口，会导致代理类十分繁多，不易维护，同时一旦 接口增加方法，则目标对象和代理类都需要维护。
 * 
 * @author XU.WJ 2018年2月26日
 */
public class ProxySubject implements Subject {

	private RealSubject realSubject = null;

	public ProxySubject(RealSubject realSubject) {
		this.realSubject = realSubject;
	}

	@Override
	public void say(String name) {
		// 在转调具体的目标对象之前，可以执行一些功能处理，比如权限判断
		eat();

		// 转调具体的目标对象
		realSubject.say(name);

		// 在转调具体的目标对象之后，可以执行一些功能处理
		// 这也是代理模式的核心
		drink();
	}

	public void eat() {
		System.out.println("我是代理对象，我要吃");
	}

	public void drink() {
		System.out.println("我是代理对象，我要喝");
	}

}
