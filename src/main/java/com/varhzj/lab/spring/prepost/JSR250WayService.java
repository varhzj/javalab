package com.varhzj.lab.spring.prepost;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class JSR250WayService {

	public JSR250WayService() {
		super();
		System.out.println("Default-constructor: JSR250WayService");
	}

	@PostConstruct
	public void init() {
		System.out.println("jsr250-init-method");
	}

	@PreDestroy
	public void destory() {
		System.out.println("jsr250-destory-method");
	}

}
