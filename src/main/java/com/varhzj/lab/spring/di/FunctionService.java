package com.varhzj.lab.spring.di;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(value = "prototype")
public class FunctionService {

	public FunctionService() {
		System.out.println("FunctionService");
	}

	public String sayHello(String word) {
		return "Hello " + word + " !";
	}

}
