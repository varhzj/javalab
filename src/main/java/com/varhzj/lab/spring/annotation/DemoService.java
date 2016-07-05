package com.varhzj.lab.spring.annotation;

import org.springframework.stereotype.Service;

@Service
public class DemoService {

	public void outputResult() {
		System.out.println("get from combined configuration");
	}

}
