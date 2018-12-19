package com.varhzj.lab.spring.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UseFunctionConstructService {

	private FunctionService functionService;

	@Autowired
	public UseFunctionConstructService(FunctionService functionService) {
		this.functionService = functionService;
	}

	public String sayHello(String word) {
		return functionService.sayHello(word);
	}
}
