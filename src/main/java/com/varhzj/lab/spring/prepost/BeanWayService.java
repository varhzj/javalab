package com.varhzj.lab.spring.prepost;

public class BeanWayService {

	public BeanWayService() {
		super();
		System.out.println("Default-constructor: BeanWayService");
	}

	public void init() {
		System.out.println("@Bean-init-method");
	}

	public void destroy() {
		System.out.println("@Bean-destroy-method");
	}

}
