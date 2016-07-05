package com.varhzj.lab.spring.di;

import org.springframework.stereotype.Service;

@Service
public class FunctionService {

	public String sayHello(String word) {
		return "Hello " + word + " !";
	}

}
